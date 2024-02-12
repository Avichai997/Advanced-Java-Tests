package test17;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainTrain2 {

	public static void check(Map<Character, List<String>> dic, char c, int i, String word) {
		try {
			if (!dic.get(c).get(i).equals(word))
				System.out.println("your dictionary is no in order (-2)");
		} catch (Exception e) {
			System.out.println("your dictionary throws an exception (-2)");
		}
	}

	public static void main(String[] args) {
		// check dictionary
		List<String> words = Arrays.asList("coco", "app", "ball", "better", "apolo");
		try {
			Map<Character, List<String>> dic = Q2.dictionary(words);
			check(dic, 'a', 0, "apolo");
			check(dic, 'a', 1, "app");
			check(dic, 'b', 0, "ball");
			check(dic, 'b', 1, "better");
			check(dic, 'c', 0, "coco");
		} catch (Exception e) {
			System.out.println("your dictionary throws an exception (-11)");
		}

		// check totalErrorsLength
		try {
			List<String> log = Arrays.asList("somthing", "blaa", "error: bla", "Error: count this", "apolo",
					"Error: and this");
			if (Q2.totalErrorsLength(log) != (17 + 15))
				System.out.println("you returned a wrong length (-11)");
		} catch (Exception e) {
			System.out.println("your totalErrorsLength throws an exception (-11)");
		}

		// check sqr sum of dists
		List<Point> ps = Arrays.asList(new Point(0, 5), new Point(10, 0));
		try {
			double d = Q2.sumSqrDists(new Point(0, 0), ps);
			if (d != 25 + 100)
				System.out.println("you returned a wrong sqr sum of dists (-11)");
		} catch (Exception e) {
			System.out.println("your sumSqrDists throws an exception (-11)");
		}

		System.out.println("done");
	}

}
