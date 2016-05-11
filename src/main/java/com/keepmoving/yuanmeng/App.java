package com.keepmoving.yuanmeng;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	/**
    	int[] a = new int[10];
    	System.out.println(a);
    	System.out.println(a[0]);
    	for(int s:a){
    		System.out.println(s);
    	}*/
    	System.out.println("*********************");
    	Integer[] b = new Integer[10];
    	System.out.println(b[0]);
    	System.out.println(b.toString());
    	Random random = new Random(20);
    	for(int i=0;i<b.length;i++){
    		b[i] = random.nextInt(2);
    	}
    	for(Integer i:b){
    		System.out.println(i.getClass().hashCode());
    	}
    	
    	/**
    	String[] s1 = {new String("abc"),"abc","abc"};
    	String[] s2 = {"abc","bcd","acb"};
    	
    	System.out.println(s1==s2);
    	System.out.println(s1[0]==s1[1]);
    	System.out.println(s1[0]==s2[0]);
    	
    	System.out.println(s1.equals(s2));
    	System.out.println(s1[0].equals(s1[1]));
    	System.out.println(s1[0].equals(s2[0]));
    	*/
    }
}
