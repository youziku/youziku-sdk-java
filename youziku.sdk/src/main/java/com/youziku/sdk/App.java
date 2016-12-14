package com.youziku.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    }
    
    public static Map<String, List<AppBean>> sortList(List<AppBean> list){
    	Map<String, List<AppBean>> map = new TreeMap<String, List<AppBean>>();
    	String data = "";
    	for(int i=0;i<list.size();i++){
    		AppBean bean = list.get(i);
    		if(data.equals(bean.getData())){
    			map.get(data).add(bean);
    		}else{
    			data = bean.getData();
    			List<AppBean> beans = new ArrayList<App.AppBean>();
    			beans.add(bean);
    			map.put(data, beans);
    		}
    	}
    	return map;
    }
    
    public static List<List<AppBean>> sortList2(List<AppBean> list){
    	List<List<AppBean>> listBean = new ArrayList<List<AppBean>>();
    	String data = "";
    	int index = listBean.size();
    	for(int i=0;i<list.size();i++){
    		AppBean bean = list.get(i);
    		if(data.equals(bean.getData())){
    			listBean.get(index).add(bean);
    		}else{
    			data = bean.getData();
    			List<AppBean> beans = new ArrayList<App.AppBean>();
    			beans.add(bean);
    			listBean.add(beans);
    			index = listBean.size();
    		}
    	}
    	return listBean;
    }
    
    public class AppBean{
    	private String data;
    	
    	private String name;

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
    }
}
