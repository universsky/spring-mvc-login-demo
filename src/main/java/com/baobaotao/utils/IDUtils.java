package com.baobaotao.utils;

public class IDUtils {

	/**
	 * 身份证15位转换18位
	 */
	public static String idCard15To18(String ID15) {
		String ID18 = "";
		if (ID15.length() == 18) {
			ID18 = ID15.toUpperCase();
		}
		if (ID15.length() == 15) {
			int[] w = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
			char[] A = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
			String ID17 = ID15.substring(0, 6) + "19" + ID15.substring(6, 15);
			int[] ID17Array;
			ID17Array = new int[17];
			for (int i = 0; i < 17; i++) {
				ID17Array[i] = Integer.parseInt(ID17.substring(i, i + 1));
			}
			int s = 0;
			for (int i = 0; i < 17; i++) {
				s = s + ID17Array[i] * w[i];
			}
			s = s % 11;
			ID18 = ID17 + Character.toString(A[s]);
		}
		return ID18;
	}

	public static boolean isIdentityPassportValid(String identityId) {
		// TODO Auto-generated method stub
		return true;
	}

	public static boolean isIdentityPIDValid(String identityId) {
		if (identityId == null || identityId.length() != 18) {
			if (identityId.length() == 15) {
				return isIdentityPIDValid(idCard15To18(identityId));
			} else {
				return false;
			}
		}
		int sigma = 0;
		Integer[] a = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
		String[] w = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
		for (int i = 0; i < 17; i++) {
			int ai = Integer.parseInt(identityId.substring(i, i + 1));
			int wi = a[i];
			sigma += ai * wi;
		}
		int number = sigma % 11;
		String check_number = w[number];
		if (!identityId.substring(17).equals(check_number)) {
			return false;
		} else {
			return true;
		}
	}

}
