package com.keepmoving.yuanmeng.dubboService;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) throws IOException{
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(new String[]{"dubbo-config.xml"});
		c.start();
		
		System.out.println("dubbo test");
		
		System.in.read();
	}
}
