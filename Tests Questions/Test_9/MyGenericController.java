package test;

import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class MyGenericController {
	// DO NOT CHAMGE
	public interface Command{
		void doCommand();
		int getPriority();
	}
	//---------------
	
	// you can add code here
	
	public MyGenericController(HashMap<String, Command> map) {
		// implement
	}
	
	void submit(String command){
		// implement
	}
	
	void start(int numOfThreads){
		// implement
	}
	
	void stop(){
		// implement
	}
	
	
}
