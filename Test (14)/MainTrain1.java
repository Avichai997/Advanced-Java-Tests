package test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainTrain1 {

	public static void test1() {
		List<String> list=Arrays.asList("bob","bank","academic","abs");
		
		Map<Character,List<String>> dic = Q1.makeDictionary(list);
		
		// all characters are in the dictionary
		if(!dic.keySet().contains('a') || !dic.keySet().contains('b'))
			System.out.println("not all characters are in the dictionarry (-6)");
		
		// all the words are grouped by their first character
		if(!dic.get('a').contains("academic"))
			System.out.println("not all words are grouped by their first letter (-4)");

		if(!dic.get('b').contains("bob"))
			System.out.println("not all words are grouped by their first letter (-4)");
		
		// every list is sorted
		dic.forEach((c,l)->{
			boolean b=true;
			String t=l.get(0);
			for(String s : l) {
				if(t.compareTo(s)>0) {
					b=false;
					break;
				}
				t=s;
			}
			if(!b)
				System.out.println("a list of words is not sorted (-10)");
		});
		
	}
	public static void main(String[] args) {
		test1();
		System.out.println("done");
	}
	
}
