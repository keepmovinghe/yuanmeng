package com.keepmoving.yuanmeng;

public class Test {

	public static void main(String[] args){
		Object o = new Object();
		addObject(o);
		Object o1= new Object();
		addObject(o1);
		System.out.println(o);
		System.out.println(o.i);
	}
	
	public static void addObject(final Object o){
		o.i++;
		System.out.println(o);
		System.out.println(o.i);
		
	}
}

class Object{
	int i=0;
}
