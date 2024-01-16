package test;

import java.util.List;

public class MainTrain1 {

	public static void main(String[] args) {
		Dictionary dic=new Dictionary("hello world! world    world	wonderful bye");
		List<String> ws=dic.getList('w'); // O(1) time
		if(ws!=null && ws.size()!=0) {
			if(!(ws.contains("world!")&& ws.contains("world")&& ws.contains("wonderful")))
				System.out.println("some of the words are missing (-8)");
			
			String last="";
			boolean b=true;
			for(String w : ws) {
				if(last.compareTo(w)>=0) {
					b=false;
					break;
				}
				last=w;
			}
			
			if(!b)
				System.out.println("your list is not sorted or a word appears more than once (-10)");
			
		}else {
			System.out.println("empty list returned when it should be full (-24)");
		}
		
		System.out.println("done");
	}
	
}
