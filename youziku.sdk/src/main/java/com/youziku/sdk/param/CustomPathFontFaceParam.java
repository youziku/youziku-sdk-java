package com.youziku.sdk.param;

/**
 * 自定义存储目录 请求参数
 * @author 
 *
 */
public class CustomPathFontFaceParam {
	
	/**
	 * 系统规定参数，从有字库字体使用页中"卢教"模式中获取，$youziku.load 语句中第2个参数即为AccessKey。
	 */
	private String accessKey;
	
	/**
	 * 要生成字体的文字内容
	 */
	private String content;
	
	/**
	 * 自定义存储目录路径。不允许传递文件扩展名,格式：root/dir/filename，重复将被覆盖，用户需要自己确认唯一性
	 */
	private String url;
	
	public CustomPathFontFaceParam(){}
	
	/**
	 * 自定义存储目录 请求参数
	 * @param accessKey 系统规定参数，从有字库字体使用页中"卢教"模式中获取，$youziku.load 语句中第2个参数即为AccessKey。
	 * @param content 生成内容
	 * @param url 自定义存储目录路径。不允许传递文件扩展名,格式：root/dir/filename，重复将被覆盖，用户需要自己确认唯一性
	 */
	public CustomPathFontFaceParam(String accessKey,String content,String url){
		this.accessKey = accessKey;
		this.content = content;
		this.url = url;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
