package com.youziku.sdk.core;

import com.alibaba.fastjson.JSON;

/**
 * 使用alibaba JSON开发包
 * @author gaobing
 *
 */
public class FastJsonHandler implements JsonHandler {

	/**
	 * 转换JSON对象
	 * @return json对象
	 */
	public <T> T parseObject(String text, Class<T> clazz) {
		return JSON.parseObject(text, clazz);
	}

}
