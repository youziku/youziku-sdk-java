package com.youziku.sdk.client;

import com.youziku.sdk.config.YouzikuConfig;

public class BaseServiceClient {
	
	/**
	 * 通用请求GetFontFace
	 * @param param 请求参数
	 * @param url 接口路径
	 * @param config config
	 * @param clazz 
	 * @return
	 */
	protected <T> T commonGetFontFace(String param,String url,YouzikuConfig config,Class<T> clazz){
		try {
			String response = config.getHttpHandler().request(url, param, config.getTimeOut()*60*1000);
			return config.getJsonHandler().parseObject(response, clazz);
		} catch (Exception e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
	}
	
	/**
	 * 异步通用请求GetFontFace[Async]
	 * @param param 请求参数
	 * @param url 接口路径
	 * @param config config
	 * @param callBack 异步通知类
	 * @param clazz 
	 * @return
	 */
	protected <T> void commonGetFontFaceAsync(String param,String url,YouzikuConfig config,FontFaceCallBack<T> callBack,Class<T> clazz) {
		Thread thread = new Thread(new AsyncRunnable<T>(param, url, config, callBack, clazz));
		thread.start();
	}
	
	/**
	 * 异步处理线程
	 * @author 
	 *
	 * @param <E>
	 */
	class AsyncRunnable<E> implements Runnable{
		
		private String url;
		
		private String param;
		
		private YouzikuConfig config;
		
		private FontFaceCallBack<E> callBack;
		
		private Class<E> clazz;
		
		public AsyncRunnable(String param,String url,YouzikuConfig config,FontFaceCallBack<E> callBack,Class<E> t){
			this.param = param;
			this.url = url;
			this.config = config;
			this.callBack = callBack;
			this.clazz = t;
		}

		public void run() {
			try {
				String response = config.getHttpHandler().request(url, param, config.getTimeOut()*60*1000);
				if(response==null||"".equals(response.toString())){
					throw new IllegalArgumentException("接口响应null或Empty!");
				}else{
					callBack.callBack(config.getJsonHandler().parseObject(response, clazz));
				}
			} catch (Exception e) {
				throw new IllegalArgumentException(e.fillInStackTrace());
			}
		}
	}
}
