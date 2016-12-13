package com.youziku.sdk.client;

import com.youziku.sdk.builder.ParamBuilder;
import com.youziku.sdk.common.ServiceMethod;
import com.youziku.sdk.config.YouzikuConfig;
import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.result.BatchCustomPathWoffFontFaceResult;
import com.youziku.sdk.result.BatchFontFaceResult;
import com.youziku.sdk.result.FontFaceResult;

public class YouzikuServiceClient extends BaseServiceClient implements IYouzikuServiceClient {
	
	private YouzikuConfig _config;
	
	/**
	 * 构造一个YouzikuClient
	 * @param config
	 */
	public YouzikuServiceClient(YouzikuConfig config){
		if(config==null) 
			throw new IllegalArgumentException(YouzikuConfig.class.getName()+" instance is null!");
		if(config.getHost()==null||"".equals(config.getHost()))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()+" field url is null or Empty!");
		if(config.getApiKey()==null||"".equals(config.getApiKey()))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()+" field apiKey is null or Empty!");
		this._config = config;
	}
	
	/**
	 * <p>构造一个YouzikuClient</p>
	 * <p>Host默认为 http://service.youziku.com</p>
	 * @param apiKey
	 */
	public YouzikuServiceClient(String apiKey){
		if(apiKey==null||"".equals(apiKey))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()+" field apiKey is null or Empty!");
		_config = new YouzikuConfig();
		_config.setApiKey(apiKey);
		_config.setHost("http://service.youziku.com");
	}
	
	/**
	 * 构造一个YouzikuClient
	 * @param apiKey
	 * @param host
	 */
	public YouzikuServiceClient(String apiKey,String host){
		if(host==null||"".equals(host))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()+" field url is null or Empty!");
		if(apiKey==null||"".equals(apiKey))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()+" field apiKey is null or Empty!");
		_config = new YouzikuConfig();
		_config.setApiKey(apiKey);
		_config.setHost(host);
	}

	public FontFaceResult getFontFace(FontFaceParam fontFace) {
		String paramStr = ParamBuilder.getFontface(fontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()+ServiceMethod.WebFont.GetFontface, _config,FontFaceResult.class);
	}

	public void getFontFaceAsync(FontFaceParam fontFace,FontFaceCallBack<FontFaceResult> callBack) {
		String paramStr = ParamBuilder.getFontface(fontFace, _config);
		commonGetFontFaceAsync(paramStr, _config.getHost()+ServiceMethod.WebFont.GetFontface, _config, callBack, FontFaceResult.class);
	}

	public FontFaceResult getWoffBase64StringFontFace(FontFaceParam fontFace) {
		String paramStr = ParamBuilder.getFontface(fontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()+ServiceMethod.WebFont.GetWoffBase64StringFontFace, _config,FontFaceResult.class);
	}

	public void getWoffBase64StringFontFaceAsync(FontFaceParam fontFace,FontFaceCallBack<FontFaceResult> callBack) {
		String paramStr = ParamBuilder.getFontface(fontFace, _config);
		commonGetFontFaceAsync(paramStr, _config.getHost()+ServiceMethod.WebFont.GetWoffBase64StringFontFace, _config,callBack,FontFaceResult.class);
	}

	public BatchFontFaceResult getBatchFontFace(BatchFontFaceParam batchFontFace) {
		String paramStr = ParamBuilder.getBatchFontFace(batchFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()+ServiceMethod.BatchWebFont.GetBatchFontFace, _config,BatchFontFaceResult.class);
	}

	public void getBatchFontFaceAsync(BatchFontFaceParam batchFontFace,FontFaceCallBack<BatchFontFaceResult> callBack) {
		String paramStr = ParamBuilder.getBatchFontFace(batchFontFace, _config);
		commonGetFontFaceAsync(paramStr, _config.getHost()+ServiceMethod.BatchWebFont.GetBatchFontFace, _config,callBack,BatchFontFaceResult.class);
	}

	public BatchFontFaceResult getBatchWoffFontFace(BatchFontFaceParam batchFontFace) {
		String paramStr = ParamBuilder.getBatchFontFace(batchFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()+ServiceMethod.BatchWebFont.GetBatchWoffFontFace, _config,BatchFontFaceResult.class);
	}

	public void getBatchWoffFontFaceAsync(BatchFontFaceParam batchFontFace,FontFaceCallBack<BatchFontFaceResult> callBack) {
		String paramStr = ParamBuilder.getBatchFontFace(batchFontFace, _config);
		commonGetFontFaceAsync(paramStr, _config.getHost()+ServiceMethod.BatchWebFont.GetBatchWoffFontFace, _config,callBack,BatchFontFaceResult.class);
	}

	public BatchCustomPathWoffFontFaceResult getCustomPathBatchWoffWebFont(
			BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace) {
		String paramStr = ParamBuilder.getCustomPathBatchWoffWebFont(batchCustomPathWoffFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()+ServiceMethod.CustomPath.CreateBatchWoffWebFont, _config,BatchCustomPathWoffFontFaceResult.class);
	}

	public void getCustomPathBatchWoffWebFontAsync(
			BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace,FontFaceCallBack<BatchCustomPathWoffFontFaceResult> callBack) {
		String paramStr = ParamBuilder.getCustomPathBatchWoffWebFont(batchCustomPathWoffFontFace, _config);
		commonGetFontFaceAsync(paramStr, _config.getHost()+ServiceMethod.CustomPath.CreateBatchWoffWebFont, _config,callBack,BatchCustomPathWoffFontFaceResult.class);
	}

}
