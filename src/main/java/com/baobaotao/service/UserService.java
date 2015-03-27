/**
 * 
 */
package com.baobaotao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.*;
import com.baobaotao.domain.*;

/**
 * @author chenguangjian 2015年3月25日 上午11:51:02
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean hasMatchUser(String userName, String password) {
		int matchCount = userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	public void loginSuccess(User user) {
		user.setCredit(user.getCredit() + 3);
		LoginLog loginLog = new LoginLog();
		loginLog.setUserID(user.getUserId());
		loginLog.setIp(user.getLastIP());
		loginLog.setLoginDate(user.getLastVisit());

		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}

}
