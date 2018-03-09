package com.youziku.sdk.core;

/**
 * json转javaBean处理程序
 * @author 
 *
 */
public interface JsonHandler {
	
	/**
	 * 将指定字符串转换为JavaBean
	 * @param text
	 * @param clazz
	 * @return
	 */
	public <T> T parseObject(String text,Class<T> clazz);

}
