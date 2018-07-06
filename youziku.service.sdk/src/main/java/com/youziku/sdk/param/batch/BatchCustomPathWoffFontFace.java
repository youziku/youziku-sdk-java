package com.youziku.sdk.param.batch;

import java.util.ArrayList;
import java.util.List;

import com.youziku.sdk.param.CustomPathFontFace;

/**
 * 传递多个自定义路径和内容 请求参数
 * @author gaobing
 *
 */
public class BatchCustomPathWoffFontFace {
	
	private List<CustomPathFontFace> datas = new ArrayList<CustomPathFontFace>();
	
	public static BatchCustomPathWoffFontFace batchCustomPathWoffFontFace(CustomPathFontFace customPathFontFace){
		BatchCustomPathWoffFontFace bcpwff = new BatchCustomPathWoffFontFace();
		bcpwff.addData(customPathFontFace);
		return bcpwff;
	}
	
	public void addData(CustomPathFontFace customPathFontFace){
		datas.add(customPathFontFace);
	}
	
	public List<CustomPathFontFace> getDatas(){
		return datas;
	}

}
