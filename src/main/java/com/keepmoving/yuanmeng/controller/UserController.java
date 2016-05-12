package com.keepmoving.yuanmeng.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepmoving.yuanmeng.pojo.User;
import com.keepmoving.yuanmeng.services.interfaces.UserService;
import com.keepmoving.yuanmeng.utils.JSON2Object;
import com.keepmoving.yuanmeng.utils.Utils;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response, String phone, String password) {
		String status = "\"\"";
		String result = "";

		if (Utils.isEmpty(String.valueOf(phone)) && Utils.isEmpty(password)) {
			status = Utils.EMPTY_USERNAMEORPWD;
			result = JSON2Object.toJSONString("手机号或密码为空");
		} else {
			User user = new User();
			user.setPhone(phone);
			user.setPassword(password);
			// 调用用户登录方法
			user = userService.Login(user);
			if (user != null) {
				status = Utils.SUCCESS;
				result = JSON2Object.toJSONString(user);
			} else {
				status = Utils.ERR_USERNAMEORPWD;
				result = JSON2Object.toJSONString("登录失败");
			}
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}
}
