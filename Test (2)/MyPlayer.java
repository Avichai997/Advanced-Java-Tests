package test;

public class MyPlayer implements Player{

	@Override
	public void play() {
		System.out.println("MyPlayer - play()");
	}	
	protected void rewind(){
		System.out.println("MyPlayer - rewind()");
	}	
	protected void stop(){
		System.out.println("MyPlayer - stop()");
	}

}
