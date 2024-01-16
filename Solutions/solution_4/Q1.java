package test;

import java.awt.Point;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Q1 {

	public static class Stream<T>{
		
		
		public interface Predicate<E>{
			boolean test(E e);	// 5 points
		}
		
		BlockingQueue<T> buffer;
		volatile boolean stop;
		Thread myThread; 	// 2 points
		Stream<T> next;		// 2 points
		
		public Stream() {
			buffer=new LinkedBlockingQueue<T>();
			stop=false;			
		}
		
		
		public void push(T t){
			buffer.add(t);
		}
		
		public Stream<T> filter(Predicate<T> p){	
			
			next=new Stream<T>();
			myThread = new Thread(()->{ 	
				while(!stop){
					try {
						T item = buffer.take();
						if(p.test(item))	
							next.buffer.add(item);
					} catch (InterruptedException e) {}
				}
			});
			myThread.start();
			return next; 	
		}
		
				
		public BlockingQueue<T> getBuffer(){
			return buffer;
		}
	
		public void endOfStream() { 
			stop=true;
			if(myThread!=null)
				myThread.interrupt();
			if(next!=null)
				next.endOfStream();
		}
	}
	
	public static void mainAPI() throws Exception{
		BlockingQueue<Point> result;
		// define the stream
		Stream<Point> s=new Stream<>();		
		result = s.filter(p->p.x>=0).filter(p->p.y<=0).getBuffer();
		// the stream is still empty.
		
		// printing thread
		final boolean[] stop={false};
		new Thread(()->{			
			try {
				while(!stop[0])
					while(!result.isEmpty())
						System.out.println(result.take());
			} catch (InterruptedException e) {}
		}).start();
		
		// demo of a slow stream generation 
		Random r=new Random();
		for(int i=0;i<500;i++){
			s.push(new Point(-100+r.nextInt(201),-100+r.nextInt(201)));
			Thread.sleep(50);
		}
		// stopping the stream(s)
		s.endOfStream();
	
		// stopping the printing thread 
		stop[0]=true;
		
		// result: as new points are generated, only points with x>=0 & y<=0 are printed			
	}
}
