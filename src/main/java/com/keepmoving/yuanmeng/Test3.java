package com.keepmoving.yuanmeng;

public class Test3 {

	public static void main(String[] args) {
		System.out.println(new Test3().getX(10));
	}

	public int getX(int x) {
		// int i=1;
		try {
			x += 3;
			return x;
		} finally {
			x = 0;
		}
	}
}
