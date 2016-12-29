package com.keepmoving.yuanmeng.dubboService;

import java.util.ArrayList;
import java.util.List;

/**
 * dubbo服务实现类
 * 
 * @author hdb
 *
 */
public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		return "Hello" + name;
	}

	public List<User> getUser() {
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setName("Jack");
		u1.setAge(18);
		u1.setSex("男");
		list.add(u1);

		User u2 = new User();
		u2.setName("Tom");
		u2.setAge(20);
		u2.setSex("男");
		list.add(u2);

		User u3 = new User();
		u3.setName("Rose");
		u3.setAge(20);
		u3.setSex("女");
		list.add(u3);

		return list;
	}

}
