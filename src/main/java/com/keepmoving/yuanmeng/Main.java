package com.keepmoving.yuanmeng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		 * HelloWorld hello = new HelloWorld(); hello.setName("Maven2");
		 */
		// ApplicationContext
		// hello.sayHello();
		
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) act.getBean("helloworld");
		helloWorld.sayHello();
	}

}
