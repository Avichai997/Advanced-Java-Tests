package test;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.function.UnaryOperator;

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
	public MyIntegerBuilder append(String s) throws Exception{
		
		try{
			Integer.parseInt(s);
		}catch(NumberFormatException e){
			throw new Exception("the string must digits an only digits");
		}
		
		for(char c : s.toCharArray())
			buff.add(c);
		return this;
	}
	
	public MyIntegerBuilder reverse() {
		ArrayList<Character> t=buff;
		buff=new ArrayList<>();
		for(int i=t.size()-1;i>=0;i--)
			buff.add(t.get(i));		
		return this;
	}
	
	
	public String toString(){
		char[] cs=new char[buff.size()];		
		for(int i=0;i<cs.length;i++)
			cs[i]=buff.get(i);
		return new String(cs);
	}
	
	public int toInt(){
		return Integer.parseInt(toString());
	}
	
}
