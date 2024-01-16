package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Controller<__________> {

	private PriorityQueue<____> queue;

	public Controller(Comparator<____> comparator) {
		queue=new PriorityQueue<____>(comparator);
	}
	
	public void insertCommand(______ c){
		queue.add(c);
	}
	
	public void executeOne(){
		if(!queue.isEmpty())
			queue.poll().execute();
	}

}
