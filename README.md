# 一、环境
1.jdk1.6.0_31及以上 <br />
2.依赖：<br />
　　　commons-httpclient-3.0.1<br />
　　　commons-logging-1.0.3<br />
　　　commons-codec-1.2<br />
　　　fastjson-1.2.5<br />

# 二、介绍

SDK适用于在java语言中调用service.youziku.com中的所有api

# 三、引用
## 1.import com.youziku.sdk.*;

# 四、Sample
## 1.初始化YouzikuServiceClient实例,在全局配置一遍即可
```java 
public static Final IYouzikuServiceClient youzikuClent = new YouzikuServiceClient("xxxxxx");//xxxxxx为用户的apikey
```
## 2.单标签模式
### 2.1 getFontface()
#### 备注:直接返回所有格式的@fontface
同步调用
``` java
FontFaceResult result = youzikuClent.getFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));//xxx为字体的accesskey
```
异步调用
``` java
youzikuClent.getFontFaceAsync(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1") , new FontFaceCallBack<FontFaceResult>() {
	public void callBack(FontFaceResult t) {
		System.out.println(JSON.toJSONString(t));
	}
});
```
### 2.2 getWoffBase64StringFontFace()
#### 备注：直接返回流（woff流）的@fontface
同步调用
``` java
FontFaceResult result = youzikuClent.getWoffBase64StringFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
```
异步调用
``` java
youzikuClent.getWoffBase64StringFontFaceAsync(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"), new FontFaceCallBack<FontFaceResult>() {
	public void callBack(FontFaceResult t) {
		System.out.println(JSON.toJSONString(t));
	}
});
```
## 3.多标签生成模式
### 1.getBatchFontFace()
#### 备注：直接返回所有格式的@fontface;可传递多个标签和内容一次生成多个@fontface
同步调用
``` java
//构建一个请求参数
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
//调用接口
BatchFontFaceResult result = youzikuClent.getBatchFontFace(bff);
```
异步调用
``` java
//构建一个请求参数
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
//调用接口
youzikuClent.getBatchFontFaceAsync(bff, new FontFaceCallBack<BatchFontFaceResult>() {			
	public void callBack(BatchFontFaceResult t) {
		int index = 0;
		for(ResponseItemResult rir:t.getFontfaceList()){
			System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
		}
	}
});
```
### 2.getBatchWoffFontFace ()
#### 备注：直接返回仅woff格式的@fontface
同步调用
``` java
//构建一个请求参数
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
//调用接口
BatchFontFaceResult result = youzikuClent.getBatchWoffFontFace(bff);
```
异步调用
``` java
//构建一个请求参数
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
//调用接口
youzikuClent.getBatchWoffFontFaceAsync(bff, new FontFaceCallBack<BatchFontFaceResult>() {
	public void callBack(BatchFontFaceResult t) {
		int index = 0;
		for(ResponseItemResult rir:t.getFontfaceList()){
			System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
		}
	}
});
```
## 4.自定义路径生成模式
### 1.CreateBatchWoffWebFontAsync()
#### 备注：自定义路径接口可以被程序异步调用，程序调用后可以直接向下执行，不需要等待返回值
同步调用
``` java
//构建一个请求参数
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让前端掌控字体！", "youziku/test-2"));
//调用接口
BatchCustomPathWoffFontFaceResult result = youzikuClent.getCustomPathBatchWoffWebFont(bcpwff2);
```
