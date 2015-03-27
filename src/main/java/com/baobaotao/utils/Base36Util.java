package com.baobaotao.utils;

import com.google.common.base.Strings;

/**
 * 36进制和十进制之间的转换工具。
 * 
 * 
 */
public class Base36Util {
	/**
	 * 36进制表示字符。
	 */
	private static final String BASE36 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * 分库分表哈希码最大值。
	 */
	public static final int MAXIMUM = getInt("ZZZZ");
	/**
	 * 分库分表哈希码最小值。
	 */
	public static final int MINIMUM = getInt("0");

	/**
	 * 把36进制的值转换成10进制的值。
	 * 
	 * @param base36
	 *            36进制值
	 * @return 十进制值。
	 */
	public static int getInt(String base36) {
		return (int) getLong(base36);
	}

	@Deprecated
	public static long getLong(String base36) {
		if (Strings.isNullOrEmpty(base36) || !base36.matches("[0-9a-zA-Z]+")) {
			throw new IllegalArgumentException();
		}
		base36 = base36.toUpperCase();
		long v = 0;
		long multiplier = 1;
		int size = base36.length();
		for (int i = size - 1; i >= 0; i--) {
			v += BASE36.indexOf(base36.charAt(i)) * multiplier;
			multiplier *= 36;
		}
		return v;
	}

	/**
	 * 把十进制Long值转换成36进制的String值。
	 * 
	 * @param base36
	 *            十进制
	 * @return 36进制。
	 */
	public static String getString(long base36) {
		StringBuilder sb = new StringBuilder();
		while (true) {
			int index = (int) (base36 % 36);
			base36 = base36 / 36;
			sb.append(BASE36.charAt(index));
			if (base36 == 0) {
				break;
			}
		}
		return sb.reverse().toString();
	}
}
