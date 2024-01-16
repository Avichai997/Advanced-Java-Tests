package test;

import java.util.List;

public class MainTrain2 {

	public static void main(String[] args) {
		// a simple test to get you going
		String text="the quick brown fox jumps over the lazy dog";
		List<String> o = Q2.orderByCount(text);
		
		String[] list= {
				"the",	// because it appears twice
				"brown", // from here its lexicographical order since each word appears once
				"dog",
				"fox",
				"jumps",
				"lazy",
				"over",
				"quick"
		};
		
		int i=0;
		boolean ok=true;
		for(String s : o) {
			if(!s.equals(list[i]))
				ok=false;
			i++;
		}
		if(!ok)
			System.out.println("your list is not ordered the right way (-50)");
		
		// the mainTest has 10 random 5 point tests..
		System.out.println("done");
	}

}
