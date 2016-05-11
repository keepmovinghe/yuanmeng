package com.keepmoving.yuanmeng.services.impls;

import org.springframework.stereotype.Service;

import com.keepmoving.yuanmeng.pojo.User;
import com.keepmoving.yuanmeng.services.interfaces.UserService;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	public void addUser(User user) {
		// this.
	}

	public User queryUser(String id) {
		return (User) this.query("user.selectUser", id);
	}

}
