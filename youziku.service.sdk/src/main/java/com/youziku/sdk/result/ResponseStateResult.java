package com.youziku.sdk.result;

/**
 * 通用响应状态结果
 * @author gaobing
 *
 */
public class ResponseStateResult {
	
	/**
	 * 状态码
	 */
	private String Code;
	
	/**
	 * 错误消息
	 */
	private String ErrorMessage;

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
	
}
