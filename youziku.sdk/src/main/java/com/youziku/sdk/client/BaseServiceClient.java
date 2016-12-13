package com.youziku.sdk.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.alibaba.fastjson.JSON;
import com.youziku.sdk.config.YouzikuConfig;

public class BaseServiceClient {
	
	/**
	 * 通用请求GetFontFace
	 * @param param 请求参数
	 * @param url 接口路径
	 * @param config config
	 * @param t 
	 * @return
	 */
	protected <T> T commonGetFontFace(String param,String url,YouzikuConfig config,Class<T> t){
		try {
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(config.getTimeOut()*60*1000);
			client.getHttpConnectionManager().getParams().setSoTimeout(config.getTimeOut()*60*1000);
			PostMethod post = new PostMethod(url);
			post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			post.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			StringRequestEntity entity = new StringRequestEntity(param);
			post.setRequestEntity(entity);
			client.executeMethod(post);
			if(post.getStatusCode()==HttpStatus.SC_OK){
				InputStream inputStream = post.getResponseBodyAsStream();   
		        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));   
		        StringBuffer response = new StringBuffer();   
		        String str= "";   
		        while((str = br.readLine()) != null){   
		        	response .append(str );   
		        }
				if(response==null||"".equals(response.toString())){
					throw new IllegalArgumentException("接口响应null或Empty!");
				}else{
					return JSON.parseObject(response.toString(), t);
				}
			}else{
				throw new IllegalArgumentException(post.getResponseBodyAsString());
			}
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
	 * @param t 
	 * @return
	 */
	protected <T> void commonGetFontFaceAsync(String param,String url,YouzikuConfig config,FontFaceCallBack<T> callBack,Class<T> t) {
		Thread thread = new Thread(new AsyncRunnable<T>(param, url, config, callBack, t));
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
				HttpClient client = new HttpClient();
				client.getHttpConnectionManager().getParams().setConnectionTimeout(config.getTimeOut()*60*1000);
				client.getHttpConnectionManager().getParams().setSoTimeout(config.getTimeOut()*60*1000);
				PostMethod post = new PostMethod(url);
				post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
				post.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				StringRequestEntity entity = new StringRequestEntity(param);
				post.setRequestEntity(entity);
				client.executeMethod(post);
				if(post.getStatusCode()==HttpStatus.SC_OK){
					InputStream inputStream = post.getResponseBodyAsStream();   
			        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));   
			        StringBuffer response = new StringBuffer();   
			        String str= "";   
			        while((str = br.readLine()) != null){   
			        	response .append(str );   
			        }
					if(response==null||"".equals(response.toString())){
						throw new IllegalArgumentException("接口响应null或Empty!");
					}else{
						callBack.callBack(JSON.parseObject(response.toString(),clazz));
					}
				}else{
					throw new IllegalArgumentException(post.getResponseBodyAsString());
				}
			} catch (Exception e) {
				throw new IllegalArgumentException(e.fillInStackTrace());
			}
		}
		
	}

}
