package com.youziku.sdk.param.batch;

import java.util.ArrayList;
import java.util.List;

import com.youziku.sdk.param.FontFaceParam;

/**
 * 多标签生成模式 请求参数
 * @author gaobing
 *
 */
public class BatchFontFaceParam {
	
	private List<FontFaceParam> tags = new ArrayList<FontFaceParam>();
	
	public static BatchFontFaceParam batchFontFace(FontFaceParam fontFace){
		BatchFontFaceParam batchFontFace = new BatchFontFaceParam();
		batchFontFace.addTag(fontFace);
		return batchFontFace;
	}
	
	public void addTag(FontFaceParam fontFace){
		tags.add(fontFace);
	}
	
	public List<FontFaceParam> getTags(){
		return tags;
	}
	
}
