package test17;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2 {

	public static Map<Character, List<String>> dictionary(List<String> words) {
		return words.stream().sorted().collect(Collectors.groupingBy(w -> w.charAt(0)));
	}

	public static int totalErrorsLength(List<String> log) {
		return log.stream().filter(s -> s.startsWith("Error:")).map(s -> s.length()).reduce(0, (x, y) -> x + y);

	}

	private static double sqrDist(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

	public static double sumSqrDists(Point p, List<Point> ps) {
		return ps.stream().map(po -> sqrDist(p, po)).reduce(0.0, (x, y) -> x + y);
	}
}
