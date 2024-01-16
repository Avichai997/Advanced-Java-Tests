package test;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {
	ArrayList<T> buff;
	
	public Buffer() {
		buff=new ArrayList<>();
	}
	
	public Buffer(T...ts) {
		buff=new ArrayList<>();
		for(T t : ts)
			buff.add(t);
	}
	
	public List<T> toList(){
		return buff;
	}
	
	// Start from here:
	//-----------------
	
	// implement append

	// implement reverese

	// implement apply
	
	
}
