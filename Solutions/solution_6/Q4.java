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
		
		int bufferSize;
		Producer<T> p;
		Consumer<T> c;
		
		Thread pThread,cThread;
		
		volatile boolean stop;
		
		ArrayBlockingQueue<T> queue;
		public ParallelStreamer(int bufferSize, Producer<T> p, Consumer<T> c) {
			this.bufferSize=bufferSize;
			this.p=p;
			this.c=c;
			queue=new ArrayBlockingQueue<>(bufferSize);
			stop=false;
		}
		
		public void start(){
			pThread= new Thread(()->{
				while(!stop) {
					try {
						queue.put(p.produce());
					} catch (InterruptedException e) {}
				}				
			});
			
			cThread= new Thread(()->{
				while(!stop) {
					try {
						c.consume(queue.take());
					} catch (InterruptedException e) {}
				}				
			});
			
			pThread.start();
			cThread.start();
		}
		
		public void stop(){
			stop=true;
			pThread.interrupt();
			cThread.interrupt();
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
		
		System.out.println("current num of theads is "+Thread.activeCount()); // should be 3 : main + producer thread + consumer thread
		
		ps.stop();
		try { Thread.sleep(10);} catch (InterruptedException e) {}
		System.out.println("current num of theads is "+Thread.activeCount()); // should be 1 : main
	}
	
}
