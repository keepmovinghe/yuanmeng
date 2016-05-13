package com.keepmoving.yuanmeng.services.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keepmoving.yuanmeng.pojo.User;
import com.keepmoving.yuanmeng.services.interfaces.UserService;

@Service(value = "userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	public User Login(User user) {
		return (User) this.queryOne("user.login", user);
	}

	public int addUser(User user) {
		return this.add("user.addUser", user);
	}

	public User queryUser(int id) {
		return (User) this.queryOne("user.selectUserById", id);
	}

	public User queryUser(String phone) {
		return (User) this.queryOne("user.selectUserByPhone", phone);
	}

	public int updateUser(User user) {
		return this.update("user.updateUser", user);
	}

	public List<Object> queryFriend(int uId) {
		return this.query("user.queryFriend", uId);
	}

}
