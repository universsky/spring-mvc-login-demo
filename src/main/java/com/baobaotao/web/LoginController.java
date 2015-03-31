/**
 * 
 */
package com.baobaotao.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;

/**
 * @author chenguangjian 2015年3月26日 下午9:14:35
 */
@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "login";
	}

	/**
	 * 
	 * @param request
	 * @param loginPoJo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			LoginPOJO loginPoJo) throws Exception {

		boolean isValidUser = userService.hasMatchUser(loginPoJo.getUserName(),
				loginPoJo.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error",
					"user name or password wrong.");
		} else {
			User user = userService.findUserByUserName(loginPoJo.getUserName());
			user.setLastIP(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);

			// put the user object into reqeust session
			request.getSession().setAttribute("user", user);

			return new ModelAndView("home");
		}

	}

}
