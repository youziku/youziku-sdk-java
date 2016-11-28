package com.youziku.sdk.config;

import com.youziku.sdk.common.RequestBaseParam;

public class YouzikuConfig extends RequestBaseParam {
    
	/**
	 * 配置接口地址
	 */
    private String host;

    /**
     * 配置发送请求超时时间[单位：分钟]，默认5分钟
     */
    private int timeOut = 5;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
    
}