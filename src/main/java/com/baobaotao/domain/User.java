/**
 * 
 */
package com.baobaotao.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
 * @author chenguangjian 2015年3月23日 下午7:41:09
 */
public class User implements Serializable {
	private int userId;
	private String userName;
	private String password;
	private int credit;
	private String lastIP;
	private Date lastVisit;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getLastIP() {
		return lastIP;
	}

	public void setLastIP(String lastIP) {
		this.lastIP = lastIP;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

}
