package youziku.sdk.test.impl;

import com.alibaba.fastjson.JSON;
import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.result.FontFaceResult;

import youziku.sdk.test.*;

class SingleTestImpl extends BaseImpl implements IInterfaceTest {

	@Override
	public Object Run(Object param) {

		// 全格式
		String message = "有字库采用国内知名云服务器厂商作为服务器，稳定、扩展性强。即便是高PV值的网站，有字库也能轻松快速地为您推送数据。 ";

		FontFaceResult fontFaceResult = YouzikuClient
				.getFontFace(new FontFaceParam(
						"xxx", message,
						"#single-java-test-1", true));
		System.out.println("全格式：" + JSON.toJSON(fontFaceResult));

		// Woff
		FontFaceResult wofffontFaceResult = YouzikuClient
				.getWoffBase64StringFontFace(new FontFaceParam(
						"xxx",
						"有字库采用国内知名云服务器厂商作为服务器，稳定、扩展性强。即便是高PV值的网站，有字库也能轻松快速地为您推送数据。 ",
						".single-java-class-1"));
		System.out.println("Woff:" + JSON.toJSON(wofffontFaceResult));

		System.out.println("这是第" + param + "次");
		return null;
	}

}
