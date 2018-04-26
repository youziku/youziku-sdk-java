package com.youziku.sdk.config;

public class SSLConfig {
	/**
	 * SSL Version
	 */
	private static String SSLVersion="TLSv1.2";
	
	public static String GetSSLVersion(){
		return SSLVersion;
	}
	
	public static void SetSSLVersion(String version){
		
		SSLVersion=version;
		
	}
}
