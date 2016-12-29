package com.keepmoving.yuanmeng.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeadLock {

	private Object rightLock = new Object();
	private Object leftLock = new Object();
	
	public void leftRight(){
		synchronized(rightLock){
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(leftLock){
				System.out.println("leftRight");
			}
		}
	}
	
	public void rightLeft(){
		synchronized(leftLock){
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(rightLock){
				System.out.println("rightLeft");
			}
		}
	}
	
	public static void main(String[] args){
		final DeadLock deadLock = new DeadLock();
		new Thread(){
			
		}.start();
		
		
		new Thread(new Runnable() {
			
			public void run() {
				deadLock.rightLeft();
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				deadLock.leftRight();
			}
		}).start();
		
	}
}
