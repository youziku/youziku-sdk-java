package com.youziku.sdk.config;

import com.youziku.sdk.common.RequestBaseParam;
import com.youziku.sdk.core.HttpProtocolHandler;
import com.youziku.sdk.core.JsonHandler;

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

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void useHttps() {
		this.setHost("https://service.youziku.com");
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public HttpProtocolHandler getHttpHandler() {
		return httpHandler;
	}

	public void setHttpHandler(HttpProtocolHandler httpHandler) {
		this.httpHandler = httpHandler;
	}

	public JsonHandler getJsonHandler() {
		return jsonHandler;
	}

	public void setJsonHandler(JsonHandler jsonHandler) {
		this.jsonHandler = jsonHandler;
	}

}