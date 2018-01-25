# 一、介绍
## 1．SDK适用语言<br/>
SDK适用于在Java中调用<a href="http://service.youziku.com">service.youziku.com</a>中的所有api<br/>

## 2. SDK工作流程<br/>　
   ①用户用后端程序调用SDK，提交动态内容到有字库的子集化(裁切)服务器<br/>
   ②服务器接收到所提交内容后，根据内容裁剪出对应的小字体文件，并转换为4种通用字体格式（woff、eot、ttf、svg）<br/>
   ③服务器将所有字体文件按用户指定的地址上传至阿里云CDN<br/>
   ④用户使用字体时，用自定义的路径，参照@font-face格式来拼出能兼容所有浏览器的@font-face语句<br/>
## 3.@font-face语句<br/>
SDK的返回值主要内容是@font-face语句，@font-face语句是CSS3中的一个功能模块，是所有浏览器天然支持的CSS语句。它的作用是将一个远程字体文件加载到当前页面，并且定义成一个字体，前端页面能够像使用本地字体一样使用该字体。@font-face语句是实现在线字体效果的核心代码。<br/>

## 4. 显示字体效果
用户<a href="#user-content-4自定义路径生成模式">自定义字体存放路径</a>，当需要显示字体效果时，可以根据自己所定义的路径<a href="http://service.youziku.com/index.html#format" target="_blank" style="color: #ff7e00;">拼组出@font-face语句</a>，然后将语句输出到前端页面，即可使内容显示字体效果。

# 二、环境
1.jdk1.6.0_31及以上 <br />
2.依赖：<br />
　　　commons-httpclient-3.0.1<br />
　　　commons-logging-1.0.3<br />
　　　commons-codec-1.2<br />
　　　fastjson-1.2.5<br />
   
3.<a href="https://github.com/youziku/youziku-sdk-java/raw/master/sdk下载/sdk.jars.zip">sdk下载</a><br />

# 三、引用
1.import com.youziku.sdk.*;

# 四、Sample
## 1.初始化YouzikuServiceClient实例,在全局配置一遍即可
```java 
public static final IYouzikuServiceClient youzikuClent = new YouzikuServiceClient("xxxxxx");//xxxxxx为用户的apikey
```
## 2.调用接口(接口分为5种模式，用户可任选一种)
### 2.1.敏捷模式-多标签woff接口：CreateBatchWoffWebFontAsync()
#### 备注：敏捷模式接口可以被程序异步调用，程序调用后可以直接向下执行，不需要等待返回值
#### &emsp;&emsp;&emsp;当需要显示字体效果时，可以根据自己所定义的路径<a href="http://service.youziku.com/index.html#format" target="_blank" style="color: #ff7e00;">拼组出@font-face语句</a>，然后将语句输出到前端页面，即可使内容显示字体效果。
同步调用
``` java
//构建一个请求参数
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让前端掌控字体！", "youziku/test-2"));
//调用接口
BatchCustomPathWoffFontFaceResult result = youzikuClent.getCustomPathBatchWoffWebFont(bcpwff2);
```
同步调用
``` java
//构建一个请求参数
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让前端掌控字体！", "youziku/test-2"));
//调用接口
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

### 2.2 语句绑定模式-单标签接口：GetFontface()
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
### 2.3 语句绑定模式-单标签Base64接口：GetWoffBase64StringFontFace()
#### 备注：直接返回Base64流（woff流）的@fontface
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

### 2.4 语句绑定模式-多标签接口：GetBatchFontFace()
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
### 2.5 语句绑定模式-多标签woff格式接口：GetBatchWoffFontFace ()
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

