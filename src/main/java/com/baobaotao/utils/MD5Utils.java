package com.baobaotao.utils;

import java.security.MessageDigest;

public class MD5Utils {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String encrypt(String strSrc) throws Exception {
		if (null == strSrc || strSrc.length() == 0) {
			return "";
		}
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		return byteArrayToHexString(md5.digest(strSrc.getBytes()));
	}

	public static String encryptWithSalt(String strSrc, String salt)
			throws Exception {
		if (null == strSrc || strSrc.length() == 0) {
			return "";
		}
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		return byteArrayToHexString(md5.digest((salt + strSrc).getBytes()));
	}

	public static void main(String[] args) {
		try {
			System.out.println(MD5Utils.encryptWithSalt("aaa", "bbb"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
