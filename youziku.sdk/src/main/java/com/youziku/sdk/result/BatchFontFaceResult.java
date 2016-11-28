package com.youziku.sdk.result;

import java.util.List;

/**
 * 多标签生成模式 响应参数
 * @author 
 *
 */
public class BatchFontFaceResult {
	
	/**
	 * 状态码
	 */
	private String Code;
	
	/**
	 * 错误消息
	 */
	private String ErrorMessage;
	
	/**
	 * 标签和对应的@fontface语句集合
	 */
	private List<ResponseItemResult> FontfaceList;

	public String getCode() {
		return Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}

	public List<ResponseItemResult> getFontfaceList() {
		return FontfaceList;
	}

	public void setFontfaceList(List<ResponseItemResult> FontfaceList) {
		this.FontfaceList = FontfaceList;
	}
	
}
