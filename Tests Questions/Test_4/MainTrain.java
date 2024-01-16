package test;

import java.util.concurrent.BlockingQueue;

import test.Q1.Stream;
import test.Q2.ConsistentHasher;
import test.Q2.TestServer;
import test.Q3.RoundList;

public class MainTrain {
	
	
	public static void main(String[] args) {
		String error="RE: Q1 has encountered an unknown runtime exception, you may submit again";		
		try{ test1a();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test1a (-5)");}
		try{ test1b();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test1b (-5) + manual chack");}
		try{ test1c();} catch (UnknownError | RuntimeException e){ System.out.println(error+ "test1c (-10)");}
		
		error="RE: Q2 has encountered an unknown runtime exception, you may submit again";		
		try{ test2a();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test2a (-5)");}
		try{ test2b();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test2b (-5) + manual check");}
		try{ test2c();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test2c (-5) + manual check");}
		try{ test2d();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test2d (-5) + manual check");}
		
		error="RE: Q3 has encountered an unknown runtime exception, you may submit again";		
		try{ test3a();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test3a (-10)");}
		try{ test3b();} catch (UnknownError | RuntimeException e){ System.out.println(error+" test3b (-5) + manual check");}

		error="RE: Q4 has encountered an unknown runtime exception, you may submit again";		
		try{ test4();} catch (UnknownError | RuntimeException e){ System.out.println(error+ " test4, really?? (-20)");}
		
	}
	
	////////////////////////////////////// test 1 //////////////////////////////////////
	static Stream<Integer> s=new Stream<>();
	static BlockingQueue<Integer> result;
	
	private static void test1a() {	// 5 points
		result = s.filter(i->(i%2==0)).filter(i->(i>50)).filter(i->(i<100)).getBuffer();
		if(Thread.activeCount()!=4) // main +3
			System.out.println("Each filter should work in its own thread (-5)");
	}
	private static void test1b() { // 15 points (test)
	}
	
	private static void test1c(){	// 10 points
		s.endOfStream();
		try { Thread.sleep(50);
		} catch (InterruptedException e) {}
		if(Thread.activeCount()!=1) // main
			System.out.println("endOfStream did not close all the threads (-10)");
	}
	

	
	////////////////////////////////////// test 2 //////////////////////////////////////
	
	
	static TestServer t1=new TestServer("AAA");
	static TestServer t2=new TestServer("BBB");
	static TestServer t3=new TestServer("CCC");
	static ConsistentHasher<Integer> ch=new ConsistentHasher<>();
	
	private static void test2a(){ // 5 points
		if(ch.hash(t1)!=105 || ch.hash(t2)!=18 || ch.hash(t3)!=291)
			System.out.println("wrong implementation of hash (-5)");
	}
	
	private static void test2b(){ // 5 points
		ch.addServer(t1);
		ch.addServer(t2);
		ch.addServer(t3);
		if(! ( ch.servers.get(0).getName().equals("BBB") && ch.servers.get(1).getName().equals("AAA") && ch.servers.get(2).getName().equals("CCC")) )
			System.out.println("wrong implementation of sort (-5)");
	}
	
	private static void test2c(){ // 10 points (test)
	}
	
	private static void test2d(){ // 10 points (test)
	}
	
	////////////////////////////////////// test 3 //////////////////////////////////////
	
	private static void test3a(){ // 10 points
		RoundList<Integer> rl=new RoundList<>();
		for(int i=0;i<5;i++)
			rl.push(5-i); // 1-5
		
		double hash=0;
		int i=0;
		for(Integer j : rl){
			hash+=Math.pow(j, i);
			i++;
		}
		if(hash!=701)
			System.out.println("wrong implementation of RoundList or its iterator (-10)");
			
	}
	
	private static void test3b(){ // 10 points (test)
	}
	
	////////////////////////////////////// test 4 //////////////////////////////////////
	private static void test4(){ // 20 points (test)
	}
}
