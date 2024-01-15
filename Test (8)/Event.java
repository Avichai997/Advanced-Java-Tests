package test;

import java.util.LinkedList;
import java.util.List;

public class Event{
	
	public interface Delegate{
		// define relevant methods here
	}

	// you can add additional data members
	String name;
	public Event(String name) {		
		this.name=name;
		// you can add code here 
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public void addDelegate(/*??*/){
		// implement
	}
	
	public void apply(){
		// implement
	}
	
	public void apply(Object about){
		// implement
	}
	
	public void bindTo(/*??*/){
		// implement
	}
}
