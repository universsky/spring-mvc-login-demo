package com.baobaotao.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AESUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);

	// 长度为24字节的加密密钥
	private static final byte[] keyBytes = { (byte) 0x88, 0x10, 0x42, 0x38,
			0x28, 0x20, 0x79, 0x50, (byte) 0xCB, (byte) 0xDD, 0x55, 0x66, 0x77,
			0x28, 0x15, (byte) 0x98 };
	private static final byte[] ivBytes = { (byte) 0x88, 0x10, 0x42, 0x38,
			0x28, 0x20, 0x79, 0x50, (byte) 0xCB, (byte) 0xDD, 0x55, 0x66, 0x77,
			0x28, 0x15, (byte) 0x98 };

	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static String encrypt(String content) {
		try {
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
			IvParameterSpec iv = new IvParameterSpec(ivBytes);

			// 创建密码器
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			// 初始化
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			byte[] result = cipher.doFinal(content.getBytes("utf-8"));

			// 加密
			return parseByte2HexStr(result);
		} catch (Exception e) {
			LOGGER.error("encrypt-" + content, e);
		}
		return "";
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static String decrypt(String content) {
		try {
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
			IvParameterSpec iv = new IvParameterSpec(ivBytes);
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, key, iv);// 初始化
			byte[] result = cipher.doFinal(parseHexStr2Byte(content));
			return new String(result); // 解密
		} catch (Exception e) {
			LOGGER.error("decrypt-" + content, e);
		}
		return "";
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			String content = "aaabbb111222";

			// 加密
			System.out.println("加密前：" + content);
			String decryptFrom = encrypt(content);
			System.out.println("加密后：" + decryptFrom);

			// 解密
			String decryptTo = decrypt(decryptFrom);
			System.out.println("解密后：" + decryptTo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
