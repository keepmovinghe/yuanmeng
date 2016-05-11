package com.keepmoving.yuanmeng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		 * HelloWorld hello = new HelloWorld(); hello.setName("Maven2");
		 */
		// ApplicationContext
		// hello.sayHello();
		ApplicationContext act = new FileSystemXmlApplicationContext("classpath:/config/spring/application-context.xml");
		
		System.out.println(act.getBean("transactionManager"));
	}

}
