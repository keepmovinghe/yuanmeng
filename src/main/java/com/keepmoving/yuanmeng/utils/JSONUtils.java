package com.keepmoving.yuanmeng.utils;

import java.util.Map;

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
	 * json string 转换为string
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJSONString(Object obj) {
		return JSON2Object.toJSONString(obj);
	}
}
