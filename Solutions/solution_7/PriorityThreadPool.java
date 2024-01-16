package test;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityThreadPool extends ThreadPoolExecutor{
	

	
	private class Helper<V> extends FutureTask<V> implements Runnable, Comparable<Helper<V>>{ 
		int priority;
		
		public Helper(Callable<V> c,int priority) {
			super(c);
			this.priority=priority;			
		}
		public Helper(Runnable run,V result, int priority) {
			super(run,result);
			this.priority=priority;			
		}
		

		@Override
		public int compareTo(Helper<V> o) {
			return priority-o.priority;
		}


	}
	

	public PriorityThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			PriorityBlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	public <V> void execute(Runnable r,V result,int priority){
		RunnableFuture<V> rh=new Helper<V>(r,result, priority);
		super.execute(rh);
	}
	
	public <V> Future<V> submit(Callable<V> c, int priority){
		RunnableFuture<V> r=new Helper<V>(c, priority);
		super.execute(r);
		return r;
	}

}
