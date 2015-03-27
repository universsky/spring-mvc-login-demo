/**
 * 
 */
package com.baobaotao.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.baobaotao.domain.*;
import com.baobaotao.result.Result;

/**
 * @author chenguangjian 2015年3月25日 下午3:53:35
 */
@org.junit.runner.RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/test/resource/spring/spring-app-baobaotao-test.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Autowired
	private LoginLogService loginLogService;

	@Test
	@Transactional
	public void testRegist() throws Exception {
		String userName = "root";
		String password = "123456";

		Result<String> result = userService.regist(userName, password);
		assertEquals(true, result.isSuccess());

	}

	/**
	 * Test method for
	 * {@link com.baobaotao.service.UserService#hasMatchUser(java.lang.String, java.lang.String)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testHasMatchUser() throws Exception {

		String userName = "admin";
		String password = "123456";

		boolean b1 = userService.hasMatchUser(userName, password);
		assertEquals(true, b1);

		boolean b2 = userService.hasMatchUser(userName + "xxx", password);
		assertEquals(false, b2);

	}

	/**
	 * Test method for
	 * {@link com.baobaotao.service.UserService#findUserByUserName(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindUserByUserName() {
		String userName = "admin";
		String password = "123456";
		User user = userService.findUserByUserName(userName);
		assertEquals(user.getUserName(), userName);
	}

	/**
	 * Test method for
	 * {@link com.baobaotao.service.UserService#loginSuccess(com.baobaotao.domain.User)}
	 * .
	 */
	@Test
	public void testLoginSuccess() {
		String userName = "admin";
		String password = "123456";
		User user = userService.findUserByUserName(userName);
		userService.loginSuccess(user);

		assertEquals(true, loginLogService.findLoginLogByUser(user).size() > 0);

	}

}
