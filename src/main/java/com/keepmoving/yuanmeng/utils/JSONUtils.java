package com.keepmoving.yuanmeng.utils;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author chenxh
 * @date 2016年12月29日
 */
public class JSONUtils {

	/**
	 * json string 转换为 map 对象
	 * 
	 * @param jsonObj
	 * @return
	 */
	public static Map<String, Object> jsonToMap(Object jsonObj) {
		JSONObject jsonObject = JSONObject.fromObject(jsonObj);
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) jsonObject;
		return map;
	}

	/**
	 * json string 转换为 对象
	 * 
	 * @param jsonObj
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(Object jsonObj, Class<T> type) {
		JSONObject jsonObject = JSONObject.fromObject(jsonObj);
		T obj = (T) JSONObject.toBean(jsonObject, type);
		return obj;
	}

	/**
	 * 返回JSONObject
	 * 
	 * @param s
	 * @return
	 */
	public static JSONObject getJSONObject(String s) {
		JSONObject jsonObject = JSONObject.fromObject(s);
		return jsonObject;
	}

	public static JSONArray getJSONArray(String s, String key) {
		JSONObject jsonObject = JSONObject.fromObject(s);
		JSONArray jsonArray = null;
		if (jsonObject.get(key) instanceof JSONArray) {
			jsonArray = jsonObject.getJSONArray(key);
		}
		return jsonArray;
	}

	/**
	 * 从JSONArray中返回map
	 * 
	 * @param jsonArray
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromJSONArray(JSONArray jsonArray) {
		Map<String, Object> objectMap = null;
		if (!jsonArray.isEmpty()) {
			if (jsonArray.get(0) instanceof Map<?, ?>) {
				objectMap = (Map<String, Object>) jsonArray.get(0);
			}
		}
		return objectMap;
	}
}
