package com.keepmoving.yuanmeng.services.impls;

import org.springframework.stereotype.Service;

import com.keepmoving.yuanmeng.pojo.User;
import com.keepmoving.yuanmeng.services.interfaces.UserService;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	public void addUser(User user) {
		// this.
	}

	public User queryUser(int id) {
		return (User) this.query("user.selectUser", id).get(0);
	}

	public User Login(User user) {
		return (User) this.queryOne("user.login", user);
	}

}
