package com.youziku.sdk.client;

import com.youziku.sdk.builder.ParamBuilder;
import com.youziku.sdk.common.ServiceMethod;
import com.youziku.sdk.config.YouzikuConfig;
import com.youziku.sdk.core.HttpProtocolHandler;
import com.youziku.sdk.core.JsonHandler;
import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.result.BatchCustomPathFontFaceResult;
import com.youziku.sdk.result.BatchFontFaceResult;
import com.youziku.sdk.result.FontFaceResult;

/**
 * YouzikuServiceClient
 * @author gaobing
 *
 */
public class YouzikuServiceClient extends BaseServiceClient implements
		IYouzikuServiceClient {

	private YouzikuConfig _config;

	 /**构建一个YouziuServiceClient
	  
	  * @param config config
	  */
	public YouzikuServiceClient(YouzikuConfig config) {
		if (config == null)
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " instance is null!");
		if (config.getHost() == null || "".equals(config.getHost()))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field url is null or Empty!");
		if (config.getApiKey() == null || "".equals(config.getApiKey()))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field apiKey is null or Empty!");
		try {
			if (config.getHttpHandler() == null) {
				config.setHttpHandler((HttpProtocolHandler) Class.forName(
						"com.youziku.sdk.core.HttpClientHandler").newInstance());
			}
			if (config.getJsonHandler() == null)
				config.setJsonHandler((JsonHandler) Class.forName(
						"com.youziku.sdk.core.FastJsonHandler").newInstance());
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
		this._config = config;
	}

	/**
	 * 构造一个YouzikuClient
	 * @author gaobing
	 * @param apiKey ApiKey
	 * @param useHttps 标识是否启用https
	 */
	public YouzikuServiceClient(String apiKey, boolean useHttps) {
		YouzikuConfig config = new YouzikuConfig();
		if (useHttps) {
			config.useHttps();
		}
		config.setApiKey(apiKey);
		if (config.getHost() == null || "".equals(config.getHost()))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field url is null or Empty!");
		if (config.getApiKey() == null || "".equals(config.getApiKey()))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field apiKey is null or Empty!");
		try {
			if (config.getHttpHandler() == null) {
				config.setHttpHandler((HttpProtocolHandler) Class.forName(
						"com.youziku.sdk.core.HttpClientHandler").newInstance());
			}
			if (config.getJsonHandler() == null)
				config.setJsonHandler((JsonHandler) Class.forName(
						"com.youziku.sdk.core.FastJsonHandler").newInstance());
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
		this._config = config;
	}

	/**
	 * 构造一个YouzikuClient ,Host默认为 http://service.youziku.com	 
	 * @param apiKey apiKey
	 */
	public YouzikuServiceClient(String apiKey) {
		if (apiKey == null || "".equals(apiKey))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field apiKey is null or Empty!");
		_config = new YouzikuConfig();
		_config.setApiKey(apiKey);
		_config.setHost("http://service.youziku.com");
		try {
			_config.setHttpHandler((HttpProtocolHandler) Class.forName(
					"com.youziku.sdk.core.HttpClientHandler").newInstance());
			_config.setJsonHandler((JsonHandler) Class.forName(
					"com.youziku.sdk.core.FastJsonHandler").newInstance());
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
	}

	/**
	 * 构造一个YouzikuClient
	 * 
	 * @param apiKey apiKey
	 * @param host host
	 */
	public YouzikuServiceClient(String host, String apiKey) {
		this(apiKey);
		if (host == null || "".equals(host))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field url is null or Empty!");
		_config.setHost(host);
		try {
			_config.setHttpHandler((HttpProtocolHandler) Class.forName(
					"com.youziku.sdk.core.HttpClientHandler").newInstance());
			_config.setJsonHandler((JsonHandler) Class.forName(
					"com.youziku.sdk.core.FastJsonHandler").newInstance());
		} catch (InstantiationException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (IllegalAccessException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
	}

	/**
	 * 构造一个YouzikuClient
	 * 
	 * @param apiKey
	 *            apiKey
	 * @param httpHandler
	 *            http请求处理程序
	 * @param jsonHandler
	 *            json转换javaBean处理程序
	 */
	public YouzikuServiceClient(String apiKey, HttpProtocolHandler httpHandler,
			JsonHandler jsonHandler) {
		if (apiKey == null || "".equals(apiKey))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field apiKey is null or Empty!");
		if (httpHandler == null)
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field httpHandler is null or Empty!");
		if (jsonHandler == null)
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field jsonHandler is null or Empty!");
		_config = new YouzikuConfig();
		_config.setApiKey(apiKey);
		_config.setHost("http://service.youziku.com");
		_config.setHttpHandler(httpHandler);
		_config.setJsonHandler(jsonHandler);
	}

	/**
	 * 构造一个YouzikuClient
	 * 
	 * @param apiKey
	 *            apiKey
	 * @param host
	 *            接口地址
	 * @param httpHandler
	 *            http请求处理程序
	 * @param jsonHandler
	 *            json转换javaBean处理程序
	 */
	public YouzikuServiceClient(String apiKey, String host,
			HttpProtocolHandler httpHandler, JsonHandler jsonHandler) {
		this(apiKey, httpHandler, jsonHandler);
		if (host == null || "".equals(host))
			throw new IllegalArgumentException(YouzikuConfig.class.getName()
					+ " field url is null or Empty!");
		_config.setHost(host);
	}

	public FontFaceResult getFontFace(FontFaceParam fontFace) {
		String paramStr = ParamBuilder.getFontface(fontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()
				+ ServiceMethod.WebFont.GetFontface, _config,
				FontFaceResult.class);
	}

	public FontFaceResult getWoffBase64StringFontFace(FontFaceParam fontFace) {
		String paramStr = ParamBuilder.getFontface(fontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()
				+ ServiceMethod.WebFont.GetWoffBase64StringFontFace, _config,
				FontFaceResult.class);
	}

	public BatchFontFaceResult getBatchFontFace(BatchFontFaceParam batchFontFace) {
		String paramStr = ParamBuilder.getBatchFontFace(batchFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()
				+ ServiceMethod.BatchWebFont.GetBatchFontFace, _config,
				BatchFontFaceResult.class);
	}

	public BatchFontFaceResult getBatchWoffFontFace(
			BatchFontFaceParam batchFontFace) {
		String paramStr = ParamBuilder.getBatchFontFace(batchFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()
				+ ServiceMethod.BatchWebFont.GetBatchWoffFontFace, _config,
				BatchFontFaceResult.class);
	}

	public BatchCustomPathFontFaceResult getCustomPathBatchWoffWebFont(
			BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace) {
		String paramStr = ParamBuilder.getCustomPathFontFace(
				batchCustomPathWoffFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()
				+ ServiceMethod.CustomPath.CreateBatchWoffWebFont, _config,
				BatchCustomPathFontFaceResult.class);
	}

	public BatchCustomPathFontFaceResult getCustomPathBatchWebFont(
			BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace) {
		String paramStr = ParamBuilder.getCustomPathFontFace(
				batchCustomPathWoffFontFace, _config);
		return commonGetFontFace(paramStr, _config.getHost()
				+ ServiceMethod.CustomPath.CreateBatchWebFont, _config,
				BatchCustomPathFontFaceResult.class);
	}

}
