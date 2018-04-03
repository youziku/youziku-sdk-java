# 1. Introduction
## 1. Use Cases<br/>
This SDK is for invoking all the API from <a href="http://service.youziku.com">service.youziku.com</a> with Java<br/>

## 2. SDK Working Flow<br/>　
- Requesting content's subsetted fonts with SDK from the server<br/>
- The server generates fonts with the four general types(woff、eot、ttf、svg)<br/>
- The server sends all the font files to the alicloud CDN user specified<br/>
- Use the fonts with @font-face on the client side<br/>
## 3.@font-face<br/>
SDK mainly returns the @font-face, which is well supported by all kinds of browsers for applying fonts on DOM.<br/>

# 2. Environment
1.jdk 1.6.0_31 or above <br />
2.Dependencies: <br />
　　　commons-httpclient-3.0.1<br />
　　　commons-logging-1.0.3<br />
　　　commons-codec-1.2<br />
　　　fastjson-1.2.5<br />

3.<a href="https://github.com/youziku/youziku-sdk-java/raw/master/sdk下载/sdk.jars.zip">sdk download</a><br />

# 3. Usage
`import com.youziku.sdk.*;`

# 4. Sample
## 1.Init YouzikuServiceClient instance
```java
public static final IYouzikuServiceClient youzikuClent = new YouzikuServiceClient("xxxxxx"); //xxxxxx: user's apikey
```
## 2.Invoke interface(user can choose any of the 5 supported modes)
### 2.1. Agile-multi-label woff mode：CreateBatchWoffWebFontAsync()
#### Note: The third parameter of `CustomPathFontFaceParam` is the Url, which can be used for constructing the font-face, for example: `src:url('http://cdn.webfont.youziku.com/webfonts/custompath/{UserKey}/{Url}.bmp') format('woff')`
Synchronize mode
``` java
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让中文跃上云端！", "youziku/test-1"));//xxx is the accesskey
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让前端掌控字体！", "youziku/test-2"));
BatchCustomPathWoffFontFaceResult result = youzikuClent.getCustomPathBatchWoffWebFont(bcpwff2);
```
Asynchronous mode
``` java
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让前端掌控字体！", "youziku/test-2"));
youzikuClent.getCustomPathBatchWoffWebFontAsync(bcpwff2,new FontFaceCallBack<BatchCustomPathWoffFontFaceResult>() {
	public void callBack(BatchCustomPathWoffFontFaceResult t) {
		if("200".equals(t.getCode())){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
	}
});

```

### 2.2 Language-binding-single-label mode：GetFontface()
#### Note:this mode returns @fontface directly
Synchronize mode
``` java
FontFaceResult result = youzikuClent.getFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
```
Asynchronous mode
``` java
youzikuClent.getFontFaceAsync(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1") , new FontFaceCallBack<FontFaceResult>() {
	public void callBack(FontFaceResult t) {
		System.out.println(JSON.toJSONString(t));
	}
});
```
### 2.3 Language-binding-single-label-Base64 mode：GetWoffBase64StringFontFace()
Synchronize mode
``` java
FontFaceResult result = youzikuClent.getWoffBase64StringFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
```
Asynchronous mode
``` java
youzikuClent.getWoffBase64StringFontFaceAsync(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"), new FontFaceCallBack<FontFaceResult>() {
	public void callBack(FontFaceResult t) {
		System.out.println(JSON.toJSONString(t));
	}
});
```

### 2.4 Language-binding-multi-label mode：GetBatchFontFace()
#### Note: this mode can generate multiple @font-face
Synchronize mode
``` java
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
BatchFontFaceResult result = youzikuClent.getBatchFontFace(bff);
```
Asynchronous mode
``` java
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
youzikuClent.getBatchFontFaceAsync(bff, new FontFaceCallBack<BatchFontFaceResult>() {
	public void callBack(BatchFontFaceResult t) {
		int index = 0;
		for(ResponseItemResult rir:t.getFontfaceList()){
			System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
		}
	}
});
```
### 2.5 Language-binding-multi-label-woff mode：GetBatchWoffFontFace ()
#### Note: as the previous x-woff mode, this mode yeild woff only result
Synchronize mode
``` java
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
BatchFontFaceResult result = youzikuClent.getBatchWoffFontFace(bff);
```
Asynchronous mode
``` java
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
youzikuClent.getBatchWoffFontFaceAsync(bff, new FontFaceCallBack<BatchFontFaceResult>() {
	public void callBack(BatchFontFaceResult t) {
		int index = 0;
		for(ResponseItemResult rir:t.getFontfaceList()){
			System.out.println("FontFace["+index+"]"+JSON.toJSONString(rir));
		}
	}
});
```
