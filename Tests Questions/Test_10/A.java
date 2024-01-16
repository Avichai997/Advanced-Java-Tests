package test;


public class A {

	private int state;
	
	public A(int state) {
		this.state = state;
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public boolean equals(A a){
		return a.state==this.state;
	}

}
