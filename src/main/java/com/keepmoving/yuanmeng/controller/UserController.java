package com.keepmoving.yuanmeng.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keepmoving.yuanmeng.pojo.User;
import com.keepmoving.yuanmeng.services.interfaces.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/queryUser")
	public void queryUser() {
		User user = userService.queryUser("1");
		System.out.println(user.getName());
	}
}
