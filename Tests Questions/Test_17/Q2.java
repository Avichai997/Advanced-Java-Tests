
import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2 {

	public static Map<Character, List<String>> dictionary(List<String> words) {
		return words.stream().sorted().collect(Collectors.groupingBy(w -> w.charAt(0)));
	}

	public static int totalErrorsLength(List<String> words) {
		return words.stream().filter((word) -> word.startsWith("Error:")).map(String::length).reduce(0,
				(x, y) -> x + y);
	}

	private static double sqrDist(Point a, Point b) {
		return null;
	}

	public static double sumSqrDists(Point p, List<Point> ps) {
		return ps.stream().mapToDouble(point -> (p.x - point.x) * (p.x - point.x) + (p.y - point.y) * (p.y - point.y))
				.reduce(0.0,
						(x, y) -> x + y);
	}
}
