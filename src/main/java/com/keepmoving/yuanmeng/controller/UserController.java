package com.keepmoving.yuanmeng.controller;

import java.util.List;

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

	/**
	 * 注册用户
	 * 
	 * @param request
	 * @param response
	 * @param phone
	 * @param password
	 */
	@RequestMapping("/register")
	public void register(HttpServletRequest request, HttpServletResponse response, String phone, String password) {
		String status = "\"\"";
		String result = "";

		if (Utils.isEmpty(String.valueOf(phone)) && Utils.isEmpty(password)) {
			status = Utils.EMPTY_USERNAMEORPWD;
			result = JSON2Object.toJSONString("手机号或密码为空");
		} else {
			try {
				User user = new User();
				user.setPhone(phone);
				user.setPassword(password);// TODO 待加密
				if (userService.queryUser(phone) != null) {
					status = Utils.EMAIL_DISABLED;
					result = JSON2Object.toJSONString("手机号已注册，注册失败。");
				} else {
					// 调用注册保存方法
					userService.addUser(user);
					status = Utils.SUCCESS;
					result = JSON2Object.toJSONString("注册成功");
				}
			} catch (Exception e) {
				e.printStackTrace();
				status = Utils.SYSTEM_EXCEPTION;
				result = JSON2Object.toJSONString("注册失败");
			}
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	@RequestMapping("/updateUser")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, User user) {
		String status = "\"\"";
		String result = "";

		if (user != null) {
			try {
				// 调用更新方法
				userService.updateUser(user);
				status = Utils.SUCCESS;
				result = JSON2Object.toJSONString("修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				status = Utils.SYSTEM_EXCEPTION;
				result = JSON2Object.toJSONString("修改失败");
			}
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

	/**
	 * 查询好友
	 * 
	 * @param request
	 * @param response
	 * @param uId
	 */
	@RequestMapping("/queryFriend")
	public void updateUser(HttpServletRequest request, HttpServletResponse response, int uId) {
		String status = "\"\"";
		String result = "";

		if (Utils.isEmpty(String.valueOf(uId))) {
			status = Utils.EMPTY_DATA;
			result = JSON2Object.toJSONString("用户编号为空");
		} else {
			// 查询方法
			List<Object> friendResult = userService.queryFriend(uId);
			status = Utils.SUCCESS;
			result = JSON2Object.toJSONString(friendResult);
		}
		// 输出json
		Utils.printWriter(request, response, status, result);
	}

}
