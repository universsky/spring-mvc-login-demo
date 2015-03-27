/**
 * 
 */
package com.baobaotao.utils;

import com.google.common.base.Strings;

/**
 * 
 * @author chenguangjian 2015年3月25日 下午2:44:18
 */
public class StringUtil {

	/**
	 * 扩充给定的String值到指定长度，或者截取给定String值到指定长度。
	 * 
	 * <pre>
	 * 	trimStringWithLength("1",4)  --&gt;  "0001"
	 * 	trimStringWithLength("12345",4)  --&gt;  "2345"
	 * 	trimStringWithLength("1234",4)  --&gt;  "1234"
	 * </pre>
	 * 
	 * 本方法用于Id生成服务。
	 * 
	 * @param str
	 *            给定值。
	 * @param len
	 *            需要返回的长度。
	 * @return 返回处理以后的字符串。
	 */
	public static String trimStringWithLength(String str, int len) {
		int offset = str.length() - len;
		if (offset == 0) {
			return str;
		}
		if (offset > 0) {
			return str.substring(offset);
		}
		return Strings.repeat("0", -offset) + str;
	}

}
