package test;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class MyGenericController {

	public interface Command{
		void doCommand();
		int getPriority();
	}
	
	HashMap<String, Command> map;
	PriorityBlockingQueue<Command> queue;
	volatile boolean stop;
	Thread[] threads;
	
	public MyGenericController(HashMap<String, Command> map) {
		this.map=map;
		queue=new PriorityBlockingQueue<Command>(10, (c1,c2)->c1.getPriority()-c2.getPriority());
		stop=false;
	}
	
	void submit(String command){
		Command c=map.get(command);
		if(c!=null){
			queue.add(c);
		}
	}
	
	void start(int numOfThreads){
		threads=new Thread[numOfThreads];
		for(int i=0;i<numOfThreads;i++){
			threads[i]=new Thread(()->{
				while(!stop){
					try {
						queue.take().doCommand();
					} catch (InterruptedException e) {}
				}
			});
			threads[i].start();
		}
	}
	
	void stop(){
		stop=true;
		for(int i=0;i<threads.length;i++)
			threads[i].interrupt();
	}
	
	
}
