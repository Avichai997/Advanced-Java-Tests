package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MyStringBuilder {
	ArrayList<Character> buff;
	
	public MyStringBuilder() {
		buff=new ArrayList<>();
	}
	
	public MyStringBuilder(char...ts) {
		buff=new ArrayList<>();
		for(char t : ts)
			buff.add(t);
	}
	
	public MyStringBuilder append(String s) {
		for(char c : s.toCharArray())
			buff.add(c);
		return this;
	}
	
	public MyStringBuilder reverse() {
		ArrayList<Character> t=buff;
		buff=new ArrayList<>();
		for(int i=t.size()-1;i>=0;i--)
			buff.add(t.get(i));		
		return this;
	}
	
	public MyStringBuilder apply(UnaryOperator<Character> uop) {
		ArrayList<Character> t=buff;
		buff=new ArrayList<>();
		for(int i=0;i<t.size();i++)
			buff.add(uop.apply(t.get(i)));		
		return this;
	}
	
	public String toString(){
		char[] cs=new char[buff.size()];		
		for(int i=0;i<cs.length;i++)
			cs[i]=buff.get(i);
		return new String(cs);
	}
	
}
