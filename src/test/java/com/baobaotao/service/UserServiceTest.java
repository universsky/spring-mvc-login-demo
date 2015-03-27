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

import com.baobaotao.domain.*;

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

	String userName = "admin";
	String password = "123456";

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.baobaotao.service.UserService#hasMatchUser(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testHasMatchUser() {

		boolean b1 = userService.hasMatchUser(userName, password);
		Assert.assertTrue(b1);

		boolean b2 = userService.hasMatchUser(userName + "xxx", password);
		Assert.assertFalse(b2);

	}

	/**
	 * Test method for
	 * {@link com.baobaotao.service.UserService#findUserByUserName(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindUserByUserName() {
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
		User user = userService.findUserByUserName(userName);
		userService.loginSuccess(user);

		assertEquals(true, loginLogService.findLoginLogByUser(user).size() > 0);

	}

}
