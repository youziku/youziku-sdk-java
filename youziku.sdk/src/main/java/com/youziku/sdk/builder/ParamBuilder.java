package com.youziku.sdk.builder;

import com.youziku.sdk.config.YouzikuConfig;
import com.youziku.sdk.param.CustomPathFontFaceParam;
import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.validate.ParamValidate;

/**
 * 请求参数构造器
 * @author 
 *
 */
public class ParamBuilder {
	
	/**
	 * 将FontFace对象转换为HTTP请求参数
	 * @param fontFace
	 * @param config
	 * @return
	 */
	public static String getFontface(FontFaceParam fontFace,YouzikuConfig config){
		ParamValidate.GetFontface(fontFace);
		StringBuffer sb = new StringBuffer("ApiKey=");
		sb.append(config.getApiKey());
		sb.append("&AccessKey=");
		sb.append(fontFace.getAccessKey());
		sb.append("&Content=");
		sb.append(fontFace.getContent().replaceAll("&", ""));
		sb.append("&Tag=");
		sb.append(fontFace.getTag());
		return sb.toString();
	}
	
	/**
	 * 将BatchFontFace对象转换为HTTP请求参数
	 * @param batchFontFace
	 * @param config
	 * @return
	 */
	public static String getBatchFontFace(BatchFontFaceParam batchFontFace, YouzikuConfig config){
		ParamValidate.GetBatchFontFace(batchFontFace);
		StringBuffer sb = new StringBuffer("ApiKey=");
		sb.append(config.getApiKey());
		for(int i=0;i<batchFontFace.getTags().size();i++){
			FontFaceParam fontFace = batchFontFace.getTags().get(i);
			sb.append("&Tags[").append(i).append("][AccessKey]=").append(fontFace.getAccessKey());
			sb.append("&Tags[").append(i).append("][Content]=").append(fontFace.getContent().replaceAll("&", ""));
			sb.append("&Tags[").append(i).append("][Tag]=").append(fontFace.getTag());
		}
		return sb.toString();
	}
	
	/**
	 * 将BatchCustomPathWoffFontFace对象转换为HTTP请求参数
	 * @param param
	 * @param config
	 * @return
	 */
	public static String getCustomPathBatchWoffWebFont(BatchCustomPathWoffFontFaceParam param,YouzikuConfig config){
		ParamValidate.CreateCustomPathBatchWoffWebFont(param);
		StringBuffer sb = new StringBuffer("ApiKey=");
		sb.append(config.getApiKey());
		for(int i=0;i<param.getDatas().size();i++){
			CustomPathFontFaceParam customPathFontFace = param.getDatas().get(i);
			sb.append("&Datas[").append(i).append("][AccessKey]=").append(customPathFontFace.getAccessKey());
			sb.append("&Datas[").append(i).append("][Content]=").append(customPathFontFace.getContent().replaceAll("&", ""));
			sb.append("&Datas[").append(i).append("][url]=").append(customPathFontFace.getUrl());
		}
		return sb.toString();
	}

}
