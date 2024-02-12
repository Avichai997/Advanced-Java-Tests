package test17;


import java.util.Observable;
import java.util.PriorityQueue;

public class MainTrain1 {

	public static class A extends Observable {
		int x;

		public A(int x) {
			this.x = x;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
			setChanged();
			notifyObservers();
		}
	}

	public static void main(String[] args) {
		// PriorityQueue - prioritize objects of A with smaller x value
		PriorityQueue<A> pq = new PriorityQueue<>((a1, a2) -> a1.getX() - a2.getX());

		// your implementation
		PriorityQueueProxy<A> pqp = new PriorityQueueProxy<>(pq);

		A a1 = new A(1);
		A a2 = new A(2);
		A a3 = new A(4);

		pqp.add(a1);
		pqp.add(a2);
		pqp.add(a3);
		// order should be now a1(1),a2(2),a3(4) // in pq

		// change the state of a1
		a1.setX(3);
		// pqp should automatically remove a1 and reinsert a1 to its current position on
		// pq

		// the order should now be a2(2),a1(3),a3(4)

		if (pq.poll() != a2 || pq.poll() != a1 || pq.poll() != a3)
			System.out.println("your order is not correct (-35)");

		System.out.println("done");
	}

}
