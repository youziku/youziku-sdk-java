package com.youziku.sdk.common;

/**
 * 接口方法
 * @author gaobing
 *
 */
public class ServiceMethod {
	
	/**
	 * 单标签生成方法名
	 * @author gaobing
	 *
	 */
	public class WebFont{
		
		/**
		 * 接口方法GetFontFace()
		 */
		public static final String GetFontface = "/webFont/getFontFace";
		
		/**
		 * 接口方法GetWoffBase64StringFontFace()
		 */
		public static final String GetWoffBase64StringFontFace = "/webFont/getWoffBase64StringFontFace";
	}
	
	/**
	 * batchWebFont,多标签生成方法名
	 * @author gaobing
	 *
	 */
	public class BatchWebFont{
		/**
		 * 接口方法GetBatchFontFace()
		 */
        public static final String GetBatchFontFace = "/batchWebFont/getBatchFontFace";
        
        /**
         * 接口方法GetBatchWoffFontFace()
         */
        public static final String GetBatchWoffFontFace = "/batchWebFont/getBatchWoffFontFace";
	}
	
	/**
	 * 自定义路径接口
	 * @author gaobing
	 *
	 */
    public class CustomPath
    {
    	/**
    	 * 接口方法CreateBatchWoffWebFontAsync()
    	 */
        public static final String CreateBatchWoffWebFont = "/batchCustomWebFont/createBatchWoffWebFontAsync";
        
        
        /**
    	 * 接口方法CreateBatchWebFontAsync()
    	 */
        public static final String CreateBatchWebFont = "/batchCustomWebFont/createBatchWebFontAsync";
    }

}
