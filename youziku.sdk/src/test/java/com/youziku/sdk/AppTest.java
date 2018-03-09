package com.youziku.sdk;

import com.alibaba.fastjson.JSON;
import com.youziku.sdk.client.FontFaceCallBack;
import com.youziku.sdk.client.IYouzikuServiceClient;
import com.youziku.sdk.client.YouzikuServiceClient;
import com.youziku.sdk.param.CustomPathFontFaceParam;
import com.youziku.sdk.param.FontFaceParam;
import com.youziku.sdk.param.batch.BatchCustomPathWoffFontFaceParam;
import com.youziku.sdk.param.batch.BatchFontFaceParam;
import com.youziku.sdk.result.BatchCustomPathWoffFontFaceResult;
import com.youziku.sdk.result.BatchFontFaceResult;
import com.youziku.sdk.result.FontFaceResult;
import com.youziku.sdk.result.ResponseItemResult;


public class AppTest {
	
	private static IYouzikuServiceClient youzikuClent = new YouzikuServiceClient("89cea6396460ef6e9c3a4f15f064e799", "http://service.youziku.com");
	public static final IYouzikuServiceClient youzikuClient = new YouzikuServiceClient("xxxxxx",new com.youziku.sdk.core.HttpClientHandler(),new com.youziku.sdk.core.FastJsonHandler());
	
	public static void main(String[] args) {
		sync();
		async();
	}
	
	/**
	 * 同步方法示例
	 */
	public static void sync(){
		//单标签字体
		FontFaceResult fontFaceResult = youzikuClent.getFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，&让中文跃上云端！", "#id1"));
		System.out.println(JSON.toJSON(fontFaceResult));
		//直接返回流（woff流）的@fontface
		youzikuClent.getWoffBase64StringFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
		//多标签生成模式,可传递多个标签和内容一次生成多个@fontface
		BatchFontFaceParam batchFontFace = BatchFontFaceParam.batchFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
		batchFontFace.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
		youzikuClent.getBatchFontFace(batchFontFace);
		//多标签生成模式,直接返回仅woff格式的@fontface
		youzikuClent.getBatchWoffFontFace(batchFontFace);
		//请求 自定义路径接口
		BatchCustomPathWoffFontFaceParam bcpwff = BatchCustomPathWoffFontFaceParam.batchCustomPathWoffFontFace(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-1"));
		bcpwff.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-2"));
		youzikuClent.getCustomPathBatchWoffWebFont(bcpwff);
	}
	
	/**
	 * 异步方法示例
	 */
	public static void async(){
		//单标签
		youzikuClent.getFontFaceAsync(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1") , new FontFaceCallBack<FontFaceResult>() {
			public void callBack(FontFaceResult t) {
				System.out.println(JSON.toJSONString(t));
			}
		});
		//直接返回流（woff流）的@fontface
		youzikuClent.getWoffBase64StringFontFaceAsync(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"), new FontFaceCallBack<FontFaceResult>() {
			public void callBack(FontFaceResult t) {
				System.out.println(JSON.toJSONString(t));
			}
		});
		//多标签生成模式,可传递多个标签和内容一次生成多个@fontface
		BatchFontFaceParam batchFontFace = BatchFontFaceParam.batchFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
		batchFontFace.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
		youzikuClent.getBatchFontFaceAsync(batchFontFace, new FontFaceCallBack<BatchFontFaceResult>() {
			
			public void callBack(BatchFontFaceResult t) {
				int index = 0;
				for(ResponseItemResult rir:t.getFontfaceList()){
					System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
				}
			}
		});
		//多标签生成模式,直接返回仅woff格式的@fontface
		youzikuClent.getBatchWoffFontFaceAsync(batchFontFace, new FontFaceCallBack<BatchFontFaceResult>() {
			public void callBack(BatchFontFaceResult t) {
				int index = 0;
				for(ResponseItemResult rir:t.getFontfaceList()){
					System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
				}
			}
		});
		//请求 自定义路径接口
		BatchCustomPathWoffFontFaceParam bcpwff = BatchCustomPathWoffFontFaceParam.batchCustomPathWoffFontFace(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-1"));
		bcpwff.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-2"));
		youzikuClent.getCustomPathBatchWoffWebFontAsync(bcpwff,new FontFaceCallBack<BatchCustomPathWoffFontFaceResult>() {
			public void callBack(BatchCustomPathWoffFontFaceResult t) {
				if("200".equals(t.getCode())){
					System.out.println("生成成功");
				}else{
					System.out.println("生成失败");
				}
			}
		});
	}
  
}
