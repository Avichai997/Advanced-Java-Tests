package test;

import java.util.Set;

public class MainTrain1 {

	public static void main(String[] args) {
		Dictionary dic=new Dictionary("hello world! world    world	wonderful bye");
		Set<String> ws=dic.getSet('w'); // O(1) time
		Set<String> ws1=dic.getSet('h'); // O(1) time
		Set<String> ws2=dic.getSet('b'); // O(1) time
		
		if(!(ws!=null && ws.size()>0 && ws1!=null && ws1.size()>0  && ws2!=null && ws2.size()>0 && dic.getSet('s').size()==0))
			System.out.println("not all relevent chars are in the dictionay (-6)");
		
		if(ws!=null && ws.size()!=0) {
			if(!(ws.contains("world!")&& ws.contains("world")&& ws.contains("wonderful")))
				System.out.println("some of the words are missing (-18)");
		}else {
			System.out.println("empty Set returned when it should be full (-18)");
		}
		
		System.out.println("done");
	}
	
}
