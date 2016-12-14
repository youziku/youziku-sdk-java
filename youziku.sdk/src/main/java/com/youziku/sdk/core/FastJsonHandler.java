package com.youziku.sdk.core;

import com.alibaba.fastjson.JSON;

/**
 * 使用alibaba JSON开发包
 * @author 
 *
 */
public class FastJsonHandler implements JsonHandler {

	public <T> T parseObject(String text, Class<T> clazz) {
		return JSON.parseObject(text, clazz);
	}

}
