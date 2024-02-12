package test_16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	public static void writeWords(String source, String destination) {

		try {
			HashMap<String, Integer> map = new HashMap<>();
			Scanner s = new Scanner(new BufferedReader(new FileReader(source)));
			while (s.hasNext()) {
				String word = s.next();
				if (!map.containsKey(word))
					map.put(word, 1);
				else
					map.put(word, map.get(word) + 1);
			}
			s.close();

			List<String> list = new ArrayList<>();
			// TODO
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
