package com.keepmoving.yuanmeng;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.keepmoving.yuanmeng.pojo.User;
import com.keepmoving.yuanmeng.services.interfaces.UserService;

public class Main {

	@Resource(name = "userService")
	private static UserService userService;

	public static void main(String[] args) {
		/*
		 * HelloWorld hello = new HelloWorld(); hello.setName("Maven2");
		 */
		// ApplicationContext
		// hello.sayHello();
		ApplicationContext act = new FileSystemXmlApplicationContext(
				"classpath:/config/spring/application-context.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) act.getBean("sqlSessionFactory");

		User user = userService.queryUser(1);
		System.out.println(user.getName());
		System.out.println(act.getBean("transactionManager"));
	}

}
