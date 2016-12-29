package com.keepmoving.yuanmeng.test;

public class StaticTest {

	
	
	public StaticTest(){
		System.out.println("a");
	}
	static{
		System.out.println("c");
	}
	{
		System.out.println("b");
	}
	
	//public static StaticTest tt = new StaticTest();
	public static void main(String[] args){
		//new StaticTest();
		int i,j,x;
		i=0;
		x=0;
		for(j=0;j<5;j++){
			x=i++;
			//i=i++;
			System.out.println(x);
		}
	}
}
