package com.youziku.sdk.param.batch;

import java.util.ArrayList;
import java.util.List;

import com.youziku.sdk.param.FontFace;

/**
 * 多标签生成模式 请求参数
 * @author gaobing 
 *
 */
public class BatchFontFace {
	
	private List<FontFace> tags = new ArrayList<FontFace>();
	
	public static BatchFontFace batchFontFace(FontFace fontFace){
		BatchFontFace batchFontFace = new BatchFontFace();
		batchFontFace.addTag(fontFace);
		return batchFontFace;
	}
	
	public void addTag(FontFace fontFace){
		tags.add(fontFace);
	}
	
	public List<FontFace> getTags(){
		return tags;
	}
	
}
