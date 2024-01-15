package test;

import java.util.ArrayList;
import java.util.List;

public class MyIntegerBuilder {
	
	// ----------- do not change -------- 
	ArrayList<Character> buff;
	
	public MyIntegerBuilder() {
		buff=new ArrayList<>();
	}
	
	public MyIntegerBuilder(char...ts) {
		buff=new ArrayList<>();
		for(char t : ts)
			buff.add(t);
	}
	//----------------------------------
	
	// implement append
	// implement reverse
	// implement toInt
	
}
