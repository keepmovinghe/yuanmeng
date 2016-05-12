package com.keepmoving.yuanmeng.services.interfaces;

import com.keepmoving.yuanmeng.pojo.User;

public interface UserService extends BaseService{
	
	public User Login(User user);
	
	public void addUser(User user);
	
	public User queryUser(int id);
}
