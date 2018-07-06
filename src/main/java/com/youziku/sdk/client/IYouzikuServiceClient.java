package com.youziku.sdk.client;

import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.result.BatchCustomPathFontFaceResult;
import com.youziku.sdk.result.BatchFontFaceResult;
import com.youziku.sdk.result.FontFaceResult;

/**
 * 有字库service接口客户端
 * @author gaobing
 *
 */
public interface IYouzikuServiceClient {
	
	/**
	 * 单标签模式
	 * @param fontFace 请求接口参数
	 * @author gaobing
	 * @return FontFaceResult
	 */
	public FontFaceResult getFontFace(FontFaceParam fontFace);
	


	/**
	 * 直接返回流（woff流）的@fontface
	 * @param fontFace 请求接口参数
	 * @author gaobing
	 * @return FontFaceResult
	 */
    public FontFaceResult getWoffBase64StringFontFace(FontFaceParam fontFace);
    

    /**
     * 多标签生成模式,可传递多个标签和内容一次生成多个@fontface
     * @param batchFontFace 请求参数
     * @author gaobing
     * @return BatchFontFaceResult
     */
    public BatchFontFaceResult getBatchFontFace(BatchFontFaceParam batchFontFace);
    

    /**
     * 多标签生成模式,直接返回仅woff格式的@fontface
     * @param batchFontFace 请求参数
     * @author gaobing
     * @return BatchFontFaceResult
     */
    public BatchFontFaceResult getBatchWoffFontFace(BatchFontFaceParam batchFontFace);
    

    /**
     * 请求 自定义路径接口；该接口底层实现为异步
     * @param batchCustomPathWoffFontFace 请求参数
     * @author gaobing
     * @return BatchCustomPathFontFaceResult
     */
    public BatchCustomPathFontFaceResult getCustomPathBatchWoffWebFont(BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace);
    
    /**
     * 请求 自定义路径接口；该接口底层实现为异步
     * @param batchCustomPathWoffFontFace 请求参数
     * @author gaobing 
     * @return BatchCustomPathFontFaceResult
     */
    public BatchCustomPathFontFaceResult getCustomPathBatchWebFont(BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace);
    
}
