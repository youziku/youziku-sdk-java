package com.youziku.sdk.result;

/**
 * FontFaceResult
 * @author bing-pc
 *
 */
public class FontFaceResult extends ResponseItemResult {
	
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
