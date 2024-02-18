package solutions14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	public static int[] getCount(List<String> words, String fileName) {
		int[] count = new int[words.size()];
		try {
			Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));
			while (s.hasNext()) {
				String w = s.next();
				for (int i = 0; i < count.length; i++)
					if (words.get(i).equals(w))
						count[i]++;
			}
			s.close();
		} catch (IOException e) {
		}
		return count;
	}
}
