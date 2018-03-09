package com.youziku.sdk.result;

/**
 * 通用响应结果
 * @author 
 *
 */
public class ResponseItemResult {
	
	/**
	 * 系统生成的FontFamily
	 */
	private String FontFamily;
	
	/**
	 * 标签(与提交的参数对应)
	 */
	private String Tag;
	
	/**
	 * 标签对应的@fontface语句
	 */
	private String FontFace;

	public String getFontFamily() {
		return FontFamily;
	}

	public void setFontFamily(String FontFamily) {
		this.FontFamily = FontFamily;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String Tag) {
		this.Tag = Tag;
	}

	public String getFontFace() {
		return FontFace;
	}

	public void setFontFace(String FontFace) {
		this.FontFace = FontFace;
	}
	
}
