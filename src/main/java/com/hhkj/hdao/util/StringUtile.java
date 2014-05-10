package com.hhkj.hdao.util;

/**
 * 字符串工具类
 * 
 */
public class StringUtile {
	/**
	 * 格式化首字母
	 * 
	 * @return
	 */
	public static String lowerInitial(String word) {
		if (word == null) {
			return null;
		}
		String afertInitial = word.substring(0, 1).toLowerCase();
		String afertStr = afertInitial + word.substring(1);
		return afertStr;
	}

	/**
	 * 格式化首字母
	 * 
	 * @return
	 */
	public static String upperInitial(String word) {
		if (word == null) {
			return null;
		}
		String afertInitial = word.substring(0, 1).toUpperCase();
		String afertStr = afertInitial + word.substring(1);
		return afertStr;
	}
}
