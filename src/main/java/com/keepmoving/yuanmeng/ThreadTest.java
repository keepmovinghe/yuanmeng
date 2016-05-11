package com.keepmoving.yuanmeng;

public class ThreadTest implements Runnable {
	private int count = 10;
	public void run() {
		// TODO Auto-generated method stub
		while(count>0){
			System.out.println(Thread.currentThread().getName()+" "+count--);
		}
	}

	public static void main(String[] args){
		ThreadTest thread = new ThreadTest();
		new Thread(thread).start();
		new Thread(thread).start();
		new Thread(thread).start();
	}
}


