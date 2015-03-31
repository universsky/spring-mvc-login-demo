/**
 * 
 */
package com.baobaotao.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.result.Result;
import com.baobaotao.service.UserService;

/**
 * @author chenguangjian 2015年3月27日 下午5:59:34
 */
@Controller
public class RegistController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registPage.html")
	public String loginPage() {
		return "regist";
	}

	/**
	 * 
	 * @param request
	 * @param loginPoJo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/regist.html")
	public ModelAndView regist(Model model, User user, BindingResult bindResult)
			throws Exception {
		if (bindResult.hasErrors()) {
			return new ModelAndView("login");
		}
		String userName = user.getUserName();
		String password = user.getPassword();
		Result<String> result = userService.regist(userName, password);
		if (!result.isSuccess()) {
			return new ModelAndView("regist");
		}
		return new ModelAndView("regist_success");

	}
}
