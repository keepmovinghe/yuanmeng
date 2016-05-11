package com.keepmoving.yuanmeng;

public class Test2 {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hell";
		String s3 = s2 + "o";
		if (s1 == s3) {
			System.out.println("A");
		} else if (s1.equals(s3)) {
			System.out.println("B");
		}
	}
}
