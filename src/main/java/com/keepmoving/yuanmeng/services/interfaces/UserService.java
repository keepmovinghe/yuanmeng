package com.keepmoving.yuanmeng.services.interfaces;

import java.util.List;

import com.keepmoving.yuanmeng.pojo.User;

public interface UserService extends BaseService {

	public User Login(User user);

	public int addUser(User user);

	public User queryUser(int id);

	public User queryUser(String phone);
	
	public int updateUser(User user);
	
	public List<Object> queryFriend(int uId);
}
