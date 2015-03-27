/**
 * 
 */
package com.baobaotao.result;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author chenguangjian 2015年3月27日 下午4:48:22
 */
public final class Result<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 324620575446458461L;

	/**
	 * 错误代码
	 */
	private String code;

	/**
	 * 错误详细信息
	 */
	private String message;

	/**
	 * 错误信息
	 */
	private HashMap<String, String> errorMsgs;

	/**
	 * 操作是否成功
	 */
	private boolean success = false;

	/**
	 * 返回的数据，调用失败的是，返回数据为null
	 */
	private T dataModel;

	public Result(int code, String message) {
		this.code = "" + code;
		this.message = message;
	}

	public Result(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(T dataModel) {
		this.dataModel = dataModel;
		this.success = true;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}

	public T getDataModel() {
		return dataModel;
	}

	public HashMap<String, String> getErrorMsgs() {
		return errorMsgs;
	}

	public void setErrorMsgs(HashMap<String, String> errorMsgs) {
		this.errorMsgs = errorMsgs;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", errorMsgs="
				+ errorMsgs + ", success=" + success + ", dataModel="
				+ dataModel + "]";
	}

}
