/**
 * 
 */
package com.baobaotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.dao.UserDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

/**
 * @author chenguangjian 2015年3月26日 下午4:49:12
 */

@Service
public class LoginLogService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<LoginLog> findLoginLogByUser(User user) {
		return loginLogDao.findLoginLogByUser(user);

	}
}
