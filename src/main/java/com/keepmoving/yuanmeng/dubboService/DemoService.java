package com.keepmoving.yuanmeng.dubboService;

import java.util.List;
/**
 * dubbo服务接口
 * @author hdb
 *
 */
public interface DemoService {

	String sayHello(String name);
	
	public List<User> getUser();
}
