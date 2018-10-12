package com.freeter.utils;

import java.util.regex.Pattern;

public class StringUtil {

	/**
	 * 判断数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	 }
	
	/**
	 * 判断车架号
	 * @param str
	 * @return
	 */
	public static boolean isVinNumber(String str){
	    Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{17}");
	    return pattern.matcher(str).matches();   
	 }
	
	/**
	 * 不为空返回true
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || str.trim().length()==0){
			return false;
		}else{
			return true;
		}
	}
}
