package com.youziku.sdk.validate;

import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
/**
 * 参数验证
 * @author bing-pc
 *
 */
public class ParamValidate {
	
	/**
	 * 验证GetFontface接口
	 * @param fontFace fontFace
	 */
	public static void GetFontface(final FontFaceParam fontFace){
		if(fontFace==null)
			throw new IllegalArgumentException("FontFace is null");
		if(fontFace.getAccessKey()==null||"".equals(fontFace.getAccessKey()))
			throw new IllegalArgumentException("FontFace.accessKey is null");
		if(fontFace.getContent()==null||"".equals(fontFace.getContent()))
			throw new IllegalArgumentException("FontFace.content is null");
	}
	
	/**
	 * 验证GetBatchFontFace接口
	 * @param batchFontFace  batchFontFace
	 */
	public static void GetBatchFontFace(BatchFontFaceParam batchFontFace){
		if(batchFontFace==null)
			throw new IllegalArgumentException("BatchFontFace is null");
		if(batchFontFace.getTags().size()<=0)
			throw new IllegalArgumentException("BatchFontFace.tags is null");
	}
	
	/**
	 * 验证CreateBatchWoffWebFontAsync 自定义路径接口
	 * @param param param
	 */
    public static void CreateCustomPathBatchWoffWebFont(BatchCustomPathWoffFontFaceParam param){
    	if(param==null)
    		throw new IllegalArgumentException("BatchCustomPathWoffFontFace is null");
    	if(param.getDatas().size()<=0)
    		throw new IllegalArgumentException("BatchCustomPathWoffFontFace.datas is null");
    }

}
