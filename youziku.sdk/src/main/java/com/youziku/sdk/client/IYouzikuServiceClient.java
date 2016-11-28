package com.youziku.sdk.client;

import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.result.BatchCustomPathWoffFontFaceResult;
import com.youziku.sdk.result.BatchFontFaceResult;
import com.youziku.sdk.result.FontFaceResult;

/**
 * 有字库service接口客户端
 * @author 
 *
 */
public interface IYouzikuServiceClient {
	
	/**
	 * 单标签模式
	 * @param fontFace
	 * @return
	 */
	public FontFaceResult getFontFace(FontFaceParam fontFace);
	

	
	/**
	 * 单标签，异步模式
	 * @param fontFace
	 * @return
	 */
	public void getFontFaceAsync(FontFaceParam fontFace,FontFaceCallBack<FontFaceResult> callBack);
	
	/**
	 * 直接返回流（woff流）的@fontface
	 * @param fontFace 请求接口参数
	 * @return
	 */
    public FontFaceResult getWoffBase64StringFontFace(FontFaceParam fontFace);
    
    /**
     * 直接返回流（woff流）的@fontface,异步模式
     * @param param 请求接口参数
     * @return
     */
    public void getWoffBase64StringFontFaceAsync(FontFaceParam fontFace,FontFaceCallBack<FontFaceResult> callBack);
    
    /**
     * 多标签生成模式,可传递多个标签和内容一次生成多个@fontface
     * @param batchFontFace 请求参数
     * @return
     */
    public BatchFontFaceResult getBatchFontFace(BatchFontFaceParam batchFontFace);
    
    /**
     * 异步多标签生成模式,可传递多个标签和内容一次生成多个@fontface
     * @param batchFontFace 请求参数
     * @return
     */
    public void getBatchFontFaceAsync(BatchFontFaceParam batchFontFace,FontFaceCallBack<BatchFontFaceResult> callBack);
    
    /**
     * 多标签生成模式,直接返回仅woff格式的@fontface
     * @param batchFontFace 请求参数
     * @return
     */
    public BatchFontFaceResult getBatchWoffFontFace(BatchFontFaceParam batchFontFace);
    
    /**
     * 异步多标签生成模式,直接返回仅woff格式的@fontface [Async]
     * @param batchFontFace 请求参数
     * @return
     */
    public void getBatchWoffFontFaceAsync(BatchFontFaceParam batchFontFace,FontFaceCallBack<BatchFontFaceResult> callBack);
    
    /**
     * 请求 自定义路径接口；该接口底层实现为异步
     * @param batchCustomPathWoffFontFace 请求参数
     * @return
     */
    public BatchCustomPathWoffFontFaceResult getCustomPathBatchWoffWebFont(BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace);
    
    /**
     * 异步请求 自定义路径接口；该接口底层实现为异步
     * @param batchCustomPathWoffFontFace 请求参数
     * @return
     */
    public void getCustomPathBatchWoffWebFontAsync(BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace,FontFaceCallBack<BatchCustomPathWoffFontFaceResult> callBack);

}
