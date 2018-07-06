package com.youziku.sdk.param.batch;

import java.util.ArrayList;
import java.util.List;

import com.youziku.sdk.param.CustomPathFontFaceParam;

/**
 * 传递多个自定义路径和内容 请求参数
 * @author gaobing
 *
 */
public class BatchCustomPathWoffFontFaceParam {
	
	private List<CustomPathFontFaceParam> datas = new ArrayList<CustomPathFontFaceParam>();
	
	public static BatchCustomPathWoffFontFaceParam batchCustomPathWoffFontFace(CustomPathFontFaceParam customPathFontFace){
		BatchCustomPathWoffFontFaceParam bcpwff = new BatchCustomPathWoffFontFaceParam();
		bcpwff.addData(customPathFontFace);
		return bcpwff;
	}
	
	public void addData(CustomPathFontFaceParam customPathFontFace){
		datas.add(customPathFontFace);
	}
	
	public List<CustomPathFontFaceParam> getDatas(){
		return datas;
	}

}
