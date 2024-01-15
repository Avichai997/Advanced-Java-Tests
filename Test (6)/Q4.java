package test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Q4 {

	public interface Producer<T>{
		public T produce();
	}
	
	public interface Consumer<T>{
		public void consume(T t); 
	}
	
	
	public static class ParallelStreamer<T>{
		
		public ParallelStreamer(int bufferSize, Producer<T> p, Consumer<T> c) {
		}
		
		public void start(){
		}
		
		public void stop(){
		}		
	}
	
	//------------------- test API -----------------
	public static void testAPI(){
		Random r=new Random();
		Producer<Integer> p=()->r.nextInt(100);
		Consumer<Integer> c=x->System.out.println(x);
		
		ParallelStreamer<Integer> ps=new ParallelStreamer<>(10, p, c);
		ps.start();
		
		try { Thread.sleep(1000);} catch (InterruptedException e) {}
		
		System.out.println("current num of threads is "+Thread.activeCount()); // should be 3 : main + producer thread + consumer thread
		
		ps.stop();
		try { Thread.sleep(10);} catch (InterruptedException e) {}
		System.out.println("current num of threads is "+Thread.activeCount()); // should be 1 : main
	}
	
}
