package com.youziku.sdk.common;

/**
 * 请求参数基类
 * @author gaobing
 *
 */
public class RequestBaseParam {
	
	/**
	 * ApiKey
	 */
	private String apiKey;

	/**
	 * 获取Api Key
	 * @return Api Key
	 */
	public String getApiKey() {
		return apiKey;
	}

	/**
	 * 设置ApiKey
	 * @param apiKey apiKey
	 */
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
}
