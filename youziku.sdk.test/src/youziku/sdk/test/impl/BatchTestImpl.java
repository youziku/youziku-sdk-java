package youziku.sdk.test.impl;

import com.alibaba.fastjson.JSON;
import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.result.BatchFontFaceResult;

import youziku.sdk.test.*;

class BatchTestImpl extends BaseImpl implements IInterfaceTest {

	@Override
	public Object Run(Object param) {
		// TODO Auto-generated method stub

		BatchFontFaceParam batchFontFace = BatchFontFaceParam
				.batchFontFace(new FontFaceParam(
						"xxx",
						"在项目发布到远程时，需要将远程域名，添加在有字库 白名单 中。白名单是为了保障用户的字体不被盗用，设置白名单后，远程网站就可以流畅应用有字库字体了，本地测试可不设置（已默认添加到白名单了）。 ",
						"#batch-java-id1"));

		batchFontFace
				.addTag(new FontFaceParam(
						"xxx",
						"在项目发布到远程时，需要将远程域名，添加在有字库 白名单 中。白名单是为了保障用户的字体不被盗用，设置白名单后，远程网站就可以流畅应用有字库字体了，本地测试可不设置（已默认添加到白名单了）。",
						"#batch-java-class-1", true));

		// 全格式
		BatchFontFaceResult result = YouzikuClient
				.getBatchFontFace(batchFontFace);

		System.out.println("全格式：" + JSON.toJSON(result));
		// Woff
		BatchFontFaceResult woffResult = YouzikuClient
				.getBatchWoffFontFace(batchFontFace);

		System.out.println("Woff：" + JSON.toJSON(woffResult));

		System.out.println("这是第" + param + "次");
		return null;
	}

}
