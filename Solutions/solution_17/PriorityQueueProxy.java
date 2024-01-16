package test;

import java.util.Observable;
import java.util.Observer;
import java.util.PriorityQueue;

public class PriorityQueueProxy<E extends Observable> implements Observer{

	PriorityQueue<E> pq;
	
	public PriorityQueueProxy(PriorityQueue<E> pq) {
		this.pq=pq;
	}
	
	public void add(E e) {
		e.addObserver(this);
		pq.add(e);
	}

	@Override
	public void update(Observable o, Object arg) {
		E e=null;
		for(E ei : pq)
			if(ei==o)
				e=ei;
		pq.remove(e);
		pq.add(e);
	}
}
