package test10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
	HashMap<String, Integer> map;

	public WordCounter(String fileName, HashSet<String> ignore) {
		map = new HashMap<>();

		try {
			Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
			while (scanner.hasNext()) {
				String word = scanner.next();
				if (ignore.contains(word))
					continue;

				if (!map.containsKey(word))
					map.put(word, 0);
				map.put(word, map.get(word) + 1);
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int getCount(String word) {
		if (map.containsKey(word))
			return map.get(word);
		return 0;
	}

	public List<String> getOrderedList() {
		List<String> words = new LinkedList<>();
		words.addAll(map.keySet());
		words.sort((s1, s2) -> map.get(s2) - map.get(s1));
		return words;
	}
}
