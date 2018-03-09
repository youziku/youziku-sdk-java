package youziku.sdk.test.impl;

import com.youziku.sdk.param.CustomPathFontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.result.BatchCustomPathFontFaceResult;

import youziku.sdk.test.BaseImpl;
import youziku.sdk.test.IInterfaceTest;

public class CustomPathTestImpl extends BaseImpl implements IInterfaceTest {

	@Override
	public Object Run(Object param) {
		// TODO Auto-generated method stub

		BatchCustomPathWoffFontFaceParam bcpwff = BatchCustomPathWoffFontFaceParam
				.batchCustomPathWoffFontFace(new CustomPathFontFaceParam(
						"xxx",
						"有字库为全球第一中文web font（在线字体）服务平台，专为网页设计师提供在线字体",
						"youziku/java-newtest-1"));

		bcpwff.addData(new CustomPathFontFaceParam(
				"xxx",
				" 有字库为全球第一中文web font（在线字体）服务平台，专为网页设计师提供在线字体 ",
				"youziku/java-newtest-2"));

		// 全格式
		BatchCustomPathFontFaceResult result = YouzikuClient
				.getCustomPathBatchWebFont(bcpwff);
		System.out.println("全格式:" + result.getErrorMessage());

		// Woff
		BatchCustomPathFontFaceResult woffResult = YouzikuClient
				.getCustomPathBatchWoffWebFont(bcpwff);

		System.out.println("Woff:" + woffResult.getErrorMessage());

		System.out.println("这是第" + param + "次");
		return null;
	}

}
