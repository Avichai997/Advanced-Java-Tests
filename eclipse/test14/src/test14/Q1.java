package test14;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1 {

	public static Map<Character, List<String>> makeDictionary(List<String> words) {
		return words.stream().sorted((w1, w2) -> w1.compareTo(w2)).collect(Collectors.groupingBy(w1 -> w1.charAt(00)));
	}

}
