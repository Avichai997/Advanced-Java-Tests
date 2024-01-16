package test;

import java.util.PriorityQueue;

public class MyPriorityQueue{

	PriorityQueue<A> queue;
	
	public MyPriorityQueue() {
	}
	
	public void add(A a){
		queue.add(a);
	}
	

	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public A poll(){
		return queue.poll();
	}

}
