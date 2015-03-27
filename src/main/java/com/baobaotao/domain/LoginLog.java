/**
 * 
 */
package com.baobaotao.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * @author chenguangjian 2015年3月23日 下午10:20:14
 */
public class LoginLog implements Serializable {
	private int loginID;
	private int userID;
	private String ip;
	private Date loginDate;

	public int getLoginID() {
		return loginID;
	}

	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
