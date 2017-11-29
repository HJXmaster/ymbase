package com.hjx.crawler;

public class TextUtil {

	public static boolean isEmpty(String resultTagName) {
		if(resultTagName==null||resultTagName.trim().equals("")){
			return true;
		}
		return false;
	}

}
