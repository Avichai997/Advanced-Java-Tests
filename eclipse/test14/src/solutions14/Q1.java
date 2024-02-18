package solutions14;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1 {

	public static Map<Character,List<String>> makeDictionary(List<String> words){
		Map<Character,List<String>> dic=words.stream().collect(Collectors.groupingBy(s->s.charAt(0)));
		dic.forEach((c,l)->l.sort((s1,s2)->s1.compareTo(s2)));
		return dic;
	}
}
