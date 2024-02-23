package solutions10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
	HashMap<String, Integer> counter;

	public WordCounter(String fileName, HashSet<String> ignor) {
		counter = new HashMap<>();
		try {
			Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
			while (s.hasNext()) {
				String str = s.next();
				if (!ignor.contains(str)) {
					Integer count = 0;
					if (counter.containsKey(str)) {
						count = counter.get(str);
					}
					count++;
					counter.put(str, count);
				}
			}
			s.close();
		} catch (IOException e) {
		}
	}

	public int getCount(String word) {
		return (counter.containsKey(word) ? counter.get(word) : 0);
	}

	public List<String> getOrderedList() {
		List<String> words = new LinkedList<>();
		words.addAll(counter.keySet());
		Collections.sort(words, (s1, s2) -> counter.get(s2) - counter.get(s1));
		return words;
	}
}
