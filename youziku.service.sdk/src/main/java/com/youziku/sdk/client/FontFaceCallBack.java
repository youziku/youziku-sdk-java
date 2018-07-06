package com.youziku.sdk.client;

/**
 * 异步请求时使用的回调接口
 * @author gaobing
 *
 * @param <T> 泛型
 */
public interface FontFaceCallBack<T> {
	
	public void callBack(T t);

}
