package com.youziku.sdk.config;

import com.youziku.sdk.common.RequestBaseParam;
import com.youziku.sdk.core.HttpProtocolHandler;
import com.youziku.sdk.core.JsonHandler;

/**
 * YouzikuConfig
 * @author bing-pc
 *
 */
public class YouzikuConfig extends RequestBaseParam {

	/**
	 * 配置接口地址
	 */
	private String host;

	/**
	 * 配置发送请求超时时间[单位：分钟]，默认5分钟
	 */
	private int timeOut = 5;

	/**
	 * 配置http请求的处理程序
	 */
	private HttpProtocolHandler httpHandler;

	/**
	 * 配置json转javaBean的处理程序
	 */
	private JsonHandler jsonHandler;

	/**
	 * 获取Host
	 * @return host
	 */
	public String getHost() {
		return host;
	}
 
	/**
	 * 设置Host
	 * @param host host
	 */
	public void setHost(String host) {
		this.host = host;
	}
 
	/**
	 * 使用https
	 */
	public void useHttps() {
		this.setHost("https://service.youziku.com");
	}

	/**
	 * 获取超时时间
	 * @return 超时时间
	 */
	public int getTimeOut() {
		return timeOut;
	}

	/**
	 * 设置超时时间
	 * @param timeOut 超时时间
	 */
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	/**
	 * getHttpHandler
	 * @return HttpProtocolHandler
	 */
	public HttpProtocolHandler getHttpHandler() {
		return httpHandler;
	}

	/**
	 * setHttpHandler
	 * @param httpHandler httpHandler
	 */
	public void setHttpHandler(HttpProtocolHandler httpHandler) {
		this.httpHandler = httpHandler;
	}

	/**
	 * getJsonHandler
	 * 
	 * @return JsonHandler
	 */
	public JsonHandler getJsonHandler() {
		return jsonHandler;
	}

	/**
	 * setJsonHandler
	 * @param jsonHandler jsonHandler
	 */
	public void setJsonHandler(JsonHandler jsonHandler) {
		this.jsonHandler = jsonHandler;
	}

}