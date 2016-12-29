package com.keepmoving.yuanmeng.test;

public class SynchronizeCode {

	public static void main(String[] args){
		// 创建对象锁
		final Object lock = new Object();
		
		//开启线程一
		new Thread(){
			public void run() {
				while(true){
					synchronized(lock){
						System.out.print("同步");
						System.out.println("代码");
					}
				}
			};
		}.start();
		
		
		//开启线程二
		new Thread(){
			public void run() {
				while(true){
					synchronized(lock){
						System.out.print("Synchronize");
						System.out.println("Code");
					}
				}
			};
		}.start();
	}
}
