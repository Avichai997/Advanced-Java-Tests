package test13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	public static List<String> orderByCount(String text) {
		HashMap<String, Integer> map = new HashMap<>();
		Scanner s = new Scanner(text);

		while (s.hasNext()) {
			String word = s.next();
			if (!map.containsKey(word))
				map.put(word, 0);

			map.put(word, map.get(word) + 1);

		}
		s.close();

		List<String> words = new ArrayList<>();
		words.addAll(map.keySet());

		Collections.sort(words, (s1, s2) -> {
			int r = map.get(s2) - map.get(s1);
			if (r == 0)
				r = s1.compareTo(s2);
			return r;
		});
		return words;
	}
}