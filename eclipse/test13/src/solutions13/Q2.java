package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	
	public static List<String> orderByCount(String text){
		HashMap<String,Integer> map=new HashMap<>();
		Scanner scanner=new Scanner(text);
		while(scanner.hasNext()) {
			String word=scanner.next();
			if(!map.containsKey(word)) {
				map.put(word, 1);
			}else {
				int c=map.get(word).intValue();
				c++;
				map.put(word, c);
			}
		}
		
		
		scanner.close();
		List<String> words=new ArrayList<>();
		words.addAll(map.keySet());
		Collections.sort(words,(s1,s2)->{
			int r=map.get(s2).intValue()-map.get(s1).intValue();
			if(r==0)
				r=s1.compareTo(s2);
			return r;
		});
		return words;
	}
}