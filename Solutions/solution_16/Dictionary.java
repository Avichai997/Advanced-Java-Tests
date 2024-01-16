package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Dictionary {

	HashMap<Character, Set<String>> dic;
	
	public Dictionary(String text) {
		HashMap<Character, Set<String>> map=new HashMap<>();
		Scanner s=new Scanner(text);
		while(s.hasNext()) {
			String word = s.next();
			char w=word.charAt(0);
			if(!map.containsKey(w))
				map.put(w, new HashSet<>());
			map.get(w).add(word);
		}
		s.close();
		
		dic=map;
	}
	
	public Set<String> getSet(char c){
		if(dic.containsKey(c)) {
			return dic.get(c);
		}
		return new HashSet<>();
	}
}
