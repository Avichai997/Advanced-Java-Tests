package solutions10;

import java.util.Observable;

public class A extends Observable{

	private int state;
	
	public A(int state) {
		this.state = state;
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		setChanged();
		notifyObservers();
	}
	
	public boolean equals(A a){
		return a.state==this.state;
	}

}
