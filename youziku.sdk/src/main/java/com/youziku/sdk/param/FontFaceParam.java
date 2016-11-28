package com.youziku.sdk.param;

/**
 * 单标签模式 请求参数
 * @author 
 *
 */
public class FontFaceParam {
	
	private String accessKey;
	
	private String content;
	
	private String tag;
	
	public FontFaceParam(){}
	
	/**
	 * 单标签模式
	 * @param accessKey 系统规定参数，从有字库字体使用页中"卢教"模式中获取，$youziku.load 语句中第2个参数即为AccessKey。
	 * @param content 生成内容
	 * @param tag 标签名称
	 */
	public FontFaceParam(String accessKey,String content,String tag){
		this.accessKey = accessKey;
		this.content = content;
		this.tag = tag;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
}