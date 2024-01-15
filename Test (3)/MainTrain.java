package test;


import java.util.Random;

import test.Q1.MyStack;
import test.Q2.*;


public class MainTrain {

	public static void main(String[] args) {
		test1(); // train, 10 points
		test2(); // test, 25 points
		test3(); // train, 10 points
		test4(); // train, 10 points
		test5(); // test, 15 points
	}

	private static void test1() { // train, 10 points
		int MAX=1000000;
		MyStack<Integer> stack=new MyStack<>();
		long t0=System.currentTimeMillis();
		for(int i=0;i<MAX;i++)
			stack.push(i);
		for(int i=0;i<MAX;i+=2)
			stack.pop();
		
		Random r=new Random();
		for(int i=0;i<50;i++){
			int index=MAX-500+r.nextInt(500);
			stack.contains(index);
		}
		long t1=System.currentTimeMillis();
		if(t1-t0>1500)
			System.out.println("Q1: Stack actions are not O(1) (-10)");
	}
	
	private static void test2(){ // test, 25 points
		MyStack<String> stack=new MyStack<>();
		stack.push("E1");
		//...
	}
	
	private static void test3(){ // train, 10 points
		String result = new MyWordFilter(()->"A A A B B C D D").readString();
		if(!result.equals("A;B;C;D;"))
			System.out.println("Q2: Decorator's implementation is worng (-10)");
	}

	private static void test4(){ // train, 10 points
		int[] r ={10,20,30,30,40};
		String result = new MyIntArrayToStringReader(()->r).readString();
		if(!result.startsWith("10 20 30 30 40"))
			System.out.println("Q2: Adapter's implementation is worng (-10)");
	}
	
	private static void test5(){ // test, 15 points
		//...
	}
}
