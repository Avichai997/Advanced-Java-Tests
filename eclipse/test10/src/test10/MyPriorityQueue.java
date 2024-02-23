package test10;

import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;

public class MyPriorityQueue implements Observer{

	PriorityQueue<A> queue;
	
	public MyPriorityQueue() {
		queue = new PriorityQueue<A>((a1,a2) -> a1.getState() - a2.getState());
	}
	
	public void add(A a){
		a.addObserver(this);
		queue.add(a);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		A a = (A) o;
		queue.remove(a);
		queue.add(a);
		
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public A poll(){
		return queue.poll();
	}


}
