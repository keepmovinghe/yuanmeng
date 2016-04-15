package com.keepmoving.yuanmeng;


import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testSayHello() {
		HelloWorld helloWorld = new HelloWorld("World");
		helloWorld.sayHello();

		// assertEquals("Hello World", result);
	}
}
