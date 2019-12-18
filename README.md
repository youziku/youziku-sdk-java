# 一、介绍
## 1．SDK适用语言<br/>
SDK适用于在Java中调用<a href="http://service.youziku.com">service.youziku.com</a>中的所有api<br/>

## 2. SDK工作流程<br/>　
   ①用户用后端程序调用SDK，提交内容到有字库的子集化(裁切)服务器<br/>
   ②服务器接收到所提交内容后，根据内容裁剪出对应的小字体文件，并转换为4种通用字体格式（woff、eot、ttf、svg）<br/>
   ③服务器将所有字体文件按用户指定的地址上传至阿里云CDN(如果是非敏捷模式，则会通过SDK返回@font-face语句)<br/>
   ④用户在页面上通过@font-face语句(自行拼组或调取SDK返回的)引用CDN上保存的字体文件，即可使页面上的文字显示出特定的字体效果<br/>
## 3.@font-face语句<br/>
SDK的返回值主要内容是@font-face语句，@font-face语句是CSS3中的一个功能模块，是所有浏览器天然支持的CSS语句。它的作用是将一个远程字体文件加载到当前页面，并且定义成一个字体，前端页面能够像使用本地字体一样使用该字体。@font-face语句是实现在线字体效果的核心代码。<br/>
### @font-face语句拼组
@font-face语句拼组格式如下：
```css
@font-face
{
    font-family: '{fontfamilyname}';
    src:url(https://cdn.repository.webfont.com/webfonts/custompath/{UserKey}/{Url}.gif);
    src:url(https://cdn.repository.webfont.com/webfonts/custompath/{UserKey}/{Url}.gif#iefix) format('embedded-opentype'),
    url(https://cdn.repository.webfont.com/webfonts/custompath/{UserKey}/{Url}.png) format('woff2'),
    url(https://cdn.repository.webfont.com/webfonts/custompath/{UserKey}/{Url}.bmp) format('woff'),
    url(https://cdn.repository.webfont.com/webfonts/custompath/{UserKey}/{Url}.jpg) format('truetype');
}

/* 
{fontfamilyname}是由用户自定义的；它就是WebFont所创建的字体的名字，当某个标签要引用这个WebFont时，font-family必须与它一致；同一页面，不能重复创建相同的{fontfamilyname}。

{UserKey}是服务器为每个用户专门开僻的存储空间的名字，UserKey可以从用户后台获取。

{Url}即是调用接口时所提交的参数(url)。
*/
```
例如（UserKey为"89B7CC9B4E975C85";url为"page15/h1"）：
```css
@font-face
{
    font-family: 'NotoSansCJKsc-light';
    src:url(https://cdn.repository.webfont.com/webfonts/custompath/89B7CC9B4E975C85/page15/h1.gif);
    src:url(https://cdn.repository.webfont.com/webfonts/custompath/89B7CC9B4E975C85/page15/h1.gif#iefix) format('embedded-opentype'),
    url(https://cdn.repository.webfont.com/webfonts/custompath/89B7CC9B4E975C85/page15/h1.png) format('woff2'),
    url(https://cdn.repository.webfont.com/webfonts/custompath/89B7CC9B4E975C85/page15/h1.bmp) format('woff'),
    url(https://cdn.repository.webfont.com/webfonts/custompath/89B7CC9B4E975C85/page15/h1.jpg) format('truetype');
}
```
## 4. 显示字体效果
敏捷模式：用户<a href="#user-content-4自定义路径生成模式">自定义字体存放路径</a>，当需要显示字体效果时，可以根据自己所定义的路径<a href="http://service.youziku.com/index.html#format" target="_blank" style="color: #ff7e00;">拼组出@font-face语句</a>，然后将语句输出到前端页面，即可使内容显示字体效果。<br />
非敏捷模式：用户在提交内容到SDK时，需要等待SDK返回的结果（@font-face语句），并随内容对应保存到数据库中，当需要显示字体效果时，调取与内容相对应的@font-face语句，然后将语句输出到前端页面，即可使内容显示字体效果。

# 二、环境
1)jar包方式引用<br/><br/>
1.jdk1.6.0_31及以上 <br />
2.依赖：<br />
　　　commons-httpclient-3.0.1<br />
　　　commons-logging-1.0.3<br />
　　　commons-codec-1.2<br />
　　　fastjson-1.2.5<br />
   
3.<a href="https://github.com/youziku/youziku-sdk-java/raw/master/sdk%E4%B8%8B%E8%BD%BD/youziku.java.sdk.jars.zip">sdk下载</a><br />

2)maven方式(推荐)
``` xml
    <dependency>
	<groupId>com.github.youziku</groupId>
	<artifactId>youziku.service.sdk</artifactId>
	<version>1.0</version>
    </dependency>
```

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

``` java
//构建一个请求参数
BatchCustomPathWoffFontFaceParam bcpwff2 = new BatchCustomPathWoffFontFaceParam();
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让中文跃上云端！", "youziku/test-1"));
bcpwff2.addData(new CustomPathFontFaceParam("xxx", "有字库，让前端掌控字体！", "youziku/test-2"));
//调用接口
BatchCustomPathWoffFontFaceResult result = youzikuClent.getCustomPathBatchWoffWebFont(bcpwff2);
```


### 2.2 语句绑定模式-单标签接口：GetFontface()
#### 备注:直接返回所有格式的@fontface

``` java
FontFaceResult result = youzikuClent.getFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));//xxx为字体的accesskey
```

### 2.3 语句绑定模式-单标签Base64接口：GetWoffBase64StringFontFace()
#### 备注：直接返回Base64流（woff流）的@fontface

``` java
FontFaceResult result = youzikuClent.getWoffBase64StringFontFace(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
```


### 2.4 语句绑定模式-多标签接口：GetBatchFontFace()
#### 备注：直接返回所有格式的@fontface;可传递多个标签和内容一次生成多个@fontface

``` java
//构建一个请求参数
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
//调用接口
BatchFontFaceResult result = youzikuClent.getBatchFontFace(bff);
```

### 2.5 语句绑定模式-多标签woff格式接口：GetBatchWoffFontFace ()
#### 备注：直接返回仅woff格式的@fontface

``` java
//构建一个请求参数
BatchFontFaceParam bff = new BatchFontFaceParam();
bff.addTag(new FontFaceParam("xxx", "有字库，让中文跃上云端！", "#id1"));
bff.addTag(new FontFaceParam("xxx", "有字库，让前端掌控字体！", "#id2"));
//调用接口
BatchFontFaceResult result = youzikuClent.getBatchWoffFontFace(bff);
```


