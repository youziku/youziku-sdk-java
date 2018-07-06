package com.youziku.sdk.config;

/**
 * SSLConfig
 * @author bing-pc
 *
 */
public class SSLConfig {
	/**
	 * SSL Version
	 */
	private static String SSLVersion="TLSv1.2";
	
	/**
	 * 获取SSL版本 
	 * @return SSL版本 
	 */
	public static String GetSSLVersion(){
		return SSLVersion;
	}
	
	/**
	 * 设置SSL版本
	 * @param version SSL版本
	 */
	public static void SetSSLVersion(String version){
		
		SSLVersion=version;
		
	}
}
