# 一、环境
1.jdk1.6.0_31及以上 <br />
2.依赖commons-httpclient-3.0.1
	  commons-logging-1.0.3
	  commons-codec-1.2
	  fastjson-1.2.5
# 二、介绍

SDK适用于在java语言中调用service.youziku.com中的所有api

# 三、Sample
## 1.初始化YouzikuServiceClient实例,在全局配置一遍即可
```csharp 
public static final IYouzikuServiceClient youzikuClient = new YouzikuServiceClient("xxxxxx");
```
## 2.单标签模式
### 2.1 getFontface()
#### 备注:直接返回所有格式的@fontface
同步调用
``` csharp
FontFaceResult result = youzikuClent.getFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
```
异步调用
``` csharp
youzikuClent.getFontFaceAsync(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1") , new FontFaceCallBack<FontFaceResult>() {
	public void callBack(FontFaceResult t) {
		System.out.println(JSON.toJSONString(t));
	}
});
```
### 2.2 getWoffBase64StringFontFace()
#### 备注：直接返回流（woff流）的@fontface
同步调用
``` csharp
FontFaceResult result = youzikuClent.getWoffBase64StringFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
```
异步调用
``` csharp
youzikuClent.getWoffBase64StringFontFaceAsync(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"), new FontFaceCallBack<FontFaceResult>() {
	public void callBack(FontFaceResult t) {
		System.out.println(JSON.toJSONString(t));
	}
});
```
## 3.多标签生成模式
### 1.getBatchFontFace()
#### 备注：直接返回所有格式的@fontface;可传递多个标签和内容一次生成多个@fontface
同步调用
``` csharp
//方式一
BatchFontFaceParam batchFontFace = BatchFontFace.batchFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
batchFontFace.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
youzikuClent.getBatchFontFace(batchFontFace);
//方式二
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
youzikuClent.getBatchFontFace(bff);
```
异步调用
``` csharp
//方式一
BatchFontFaceParam batchFontFace = BatchFontFace.batchFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
batchFontFace.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
youzikuClent.getBatchFontFaceAsync(batchFontFace, new FontFaceCallBack<BatchFontFaceResult>() {			
	public void callBack(BatchFontFaceResult t) {
		int index = 0;
		for(ResponseItemResult rir:t.getFontfaceList()){
			System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
		}
	}
});
//方式二
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
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
``` csharp
//构建一个请求参数
方式一
BatchFontFaceParam batchFontFace = BatchFontFace.batchFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
batchFontFace.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
youzikuClent.getBatchWoffFontFace(batchFontFace);
//方式二
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
youzikuClent.getBatchWoffFontFace(bff);
```
异步调用
``` csharp
//构建一个请求参数

方式一
BatchFontFaceParam batchFontFace = BatchFontFace.batchFontFace(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
batchFontFace.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
youzikuClent.getBatchWoffFontFaceAsync(batchFontFace, new FontFaceCallBack<BatchFontFaceResult>() {
	public void callBack(BatchFontFaceResult t) {
		int index = 0;
		for(ResponseItemResult rir:t.getFontfaceList()){
			System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
		}
	}
});
//方式二
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "#id2"));
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
``` csharp
//方式一
BatchCustomPathWoffFontFaceParam bcpwff = BatchCustomPathWoffFontFaceParam.batchCustomPathWoffFontFace(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-2"));
youzikuClent.getCustomPathBatchWoffWebFont(bcpwff);
//方式二
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-2"));
youzikuClent.getCustomPathBatchWoffWebFont(bcpwff2);
```
异步调用
``` csharp
//方式一
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
//方式二
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("f7f070be5ed0432ebeb2d39118f8aca4", "有字库，让中文跃上云端！", "youziku/test-2"));
youzikuClent.getCustomPathBatchWoffWebFontAsync(bcpwff2,new FontFaceCallBack<BatchCustomPathWoffFontFaceResult>() {
	public void callBack(BatchCustomPathWoffFontFaceResult t) {
		if("200".equals(t.getCode())){
			System.out.println("生成成功");
		}else{
			System.out.println("生成失败");
		}
	}
});
```
