package com.youziku.sdk.core;

/**
 * json转javaBean处理程序
 * @author gaobing
 *
 */
public interface JsonHandler {
	
	/**
	 * 将指定字符串转换为JavaBean
	 * @param text text
	 * @param clazz clazz
	 * @param <T> t
	 * @return 对象
	 */
	public <T> T parseObject(String text,Class<T> clazz);

}
