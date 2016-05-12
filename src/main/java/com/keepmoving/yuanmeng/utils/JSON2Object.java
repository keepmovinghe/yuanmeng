package com.keepmoving.yuanmeng.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSON2Object extends JSONObject {

	private static final SerializerFeature[] features = {
		    SerializerFeature.WriteNullListAsEmpty,
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullNumberAsZero,
			SerializerFeature.WriteNullStringAsEmpty};
	
	public static String toJSONString(Object arg) {
		return JSONObject.toJSONString(arg,features);
	}
}
