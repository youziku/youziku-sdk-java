package com.youziku.sdk.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;

/**
 * 使用commons-httpclient3.0.1开发包
 * 
 * @author
 * 
 */
public class HttpClientHandler implements HttpProtocolHandler {
	
	private HttpClient client = new HttpClient();
	
	private static final   String HTTPS="https";
	public String request(String url, String entity, int timeOut) {
		try {
			  if(url.startsWith(HTTPS)){  
                  //https请求  
                  Protocol myhttps = new Protocol(HTTPS, new YouzikuSSLProcotol(), 443);     
                  Protocol.registerProtocol(HTTPS, myhttps);  
                  //System.out.println("https");
              } 
			client.getHttpConnectionManager().getParams()
					.setConnectionTimeout(timeOut);
			client.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
			PostMethod post = new PostMethod(url);
			post.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			post.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			StringRequestEntity stringEntity = new StringRequestEntity(entity,
					null, "UTF-8");
			post.setRequestEntity(stringEntity);
			client.executeMethod(post);
			if (post.getStatusCode() == HttpStatus.SC_OK) {
				InputStream inputStream = post.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						inputStream));
				StringBuffer response = new StringBuffer();
				String str = "";
				while ((str = br.readLine()) != null) {
					response.append(str);
				}
				if (response == null || "".equals(response.toString())) {
					throw new IllegalArgumentException("接口响应null或Empty!");
				} else {
					return response.toString();
				}

			} else {
				throw new IllegalArgumentException(
						post.getResponseBodyAsString());
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e.fillInStackTrace());
		}
	}

}
