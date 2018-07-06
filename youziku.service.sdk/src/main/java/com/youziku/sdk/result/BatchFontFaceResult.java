package com.youziku.sdk.result;

import java.util.List;

/**
 * 多标签生成模式 响应参数
 * @author gaobing
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

	
	/**
	 * 获取Code
	 * @return code
	 */
	public String getCode() {
		return Code;
	}

	/**
	 * 设置code
	 * @param Code code
	 */
	public void setCode(String Code) {
		this.Code = Code;
	}

	/**
	 * 获取错误消息
	 * @return 错误消息
	 */
	public String getErrorMessage() {
		return ErrorMessage;
	}
 
	/**
	 * 设置错误消息
	 * @param ErrorMessage 错误消息
	 */
	public void setErrorMessage(String ErrorMessage) {
		this.ErrorMessage = ErrorMessage;
	}

	/**
	 * 获取fontfaceList
	 * @return fontfaceList
	 */
	public List<ResponseItemResult> getFontfaceList() {
		return FontfaceList;
	}
	
	/**
	 * 设置fontfaceList
	 * @param FontfaceList fontfaceList
	 */
	public void setFontfaceList(List<ResponseItemResult> FontfaceList) {
		this.FontfaceList = FontfaceList;
	}
	
}
