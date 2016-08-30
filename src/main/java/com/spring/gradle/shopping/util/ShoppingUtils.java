package com.spring.gradle.shopping.util;

import java.util.Date;

public class ShoppingUtils {
	public static String timeStamp() {
		String DATE_FORMAT = "yyyyMMdd_HHmmss-SSS";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				DATE_FORMAT);
		return sdf.format(new Date());
	}

	public static int randomNumber() {
		java.util.Random ran = new java.util.Random();
		return ran.nextInt(9999);
	}
}
