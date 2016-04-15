package com.keepmoving.yuanmeng;

public class HelloWorld {

	public HelloWorld() {

	}

	public HelloWorld(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sayHello() {
		System.out.println("Hello " + name);
	}
}
