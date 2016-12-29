package com.keepmoving.yuanmeng.test;

public class TicketTest implements Runnable {
	int tickets = 300;

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized ((Object) tickets) {
				try {
					Thread.currentThread().sleep(10);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (tickets > 0) {
					System.out.println(Thread.currentThread().getName() + "售票，票号为：" + tickets--);
				} else {
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		TicketTest t = new TicketTest();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}
