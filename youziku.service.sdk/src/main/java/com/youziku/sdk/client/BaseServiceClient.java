package com.youziku.sdk.client;

import com.youziku.sdk.config.YouzikuConfig;

/**
 * BaseServiceClient
 * @author bing-pc
 *
 */
public class BaseServiceClient {
	
	/**
	 * 通用请求GetFontFace
	 * @author gaobing
	 * @param param 请求参数
	 * @param url 接口路径
	 * @param config config
	 * @param clazz  clazz
	 * @param <T> t
	 * @return 对象
	 */
	protected <T> T commonGetFontFace(String param,String url,YouzikuConfig config,Class<T> clazz){
		try {
			String response = config.getHttpHandler().request(url, param, config.getTimeOut()*60*1000);
			return config.getJsonHandler().parseObject(response, clazz);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
	}
	 
}
