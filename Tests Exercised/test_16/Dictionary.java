package test_16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {
	public Map<Character, Set<String>> wordsMap;

	public Dictionary(String text) {
		wordsMap = new HashMap<>();
		initMapString(text);
	}

	public void initMapString(String text) {
		// “hello world! world world wonderful bye”

		String[] s = text.split("(?<=\\s)|(?=\\s)");

		for (int i = 0; i < s.length; i++) {

			char letter = s[i].charAt(0);

			if (wordsMap.containsKey(letter))
				wordsMap.get(letter).add(s[i]);
			else {
				Set<String> stringSet = new HashSet<>();
				stringSet.add(s[i]);

				wordsMap.put(letter, stringSet);
			}
		}
	}

	public Set<String> getSet(char c) {
		return wordsMap.containsKey(c) ? wordsMap.get(c) : new HashSet<>();
	}

}
