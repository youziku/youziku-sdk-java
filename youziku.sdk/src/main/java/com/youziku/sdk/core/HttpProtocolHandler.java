package com.youziku.sdk.core;

/**
 * Http请求处理接口
 * @author 
 *
 */
public interface HttpProtocolHandler {
	
	/**
	 * 发送一个Http请求，并返回响应的字符串
	 * @param url	请求的url
	 * @param entity	请求的内容
	 * @param timeOut	超时时间（单位分钟）
	 * @return
	 */
	public String request(String url,String entity,int timeOut);

}
