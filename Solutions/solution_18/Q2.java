package test;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2 {

	public static Map<Character, List<String>> map(Stream<String> words) {
		return words.sorted((s1, s2) -> s1.length() - s2.length())
				.collect(Collectors.groupingBy(s -> s.charAt(s.length() - 1)));
	}

	public static int total(Stream<String> log) {
		return log.filter(s -> s.length() >= 3).map(String::length).reduce(1, (x, y) -> x * y);
	}

	private static double dist(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	public static Set<Point> anomalies(List<Point> ps, double R) {
		Point avg = new Point(0, 0);
		ps.forEach(pi -> {
			avg.x += pi.x;
			avg.y += pi.y;
		});
		avg.x /= ps.size();
		avg.y /= ps.size();

		return ps.stream().filter(pi -> dist(pi, avg) > R).collect(Collectors.toSet());
	}
}
