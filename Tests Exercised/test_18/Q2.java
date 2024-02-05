

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
		return log.filter(s -> s.length() >= 3).map(s -> s.length()).reduce(1, (l1, l2) -> l1 * l2);
	}

	public static Set<Point> anomalies(List<Point> points, double R) {
		int avgX = 0;
		int avgY = 0;

		int[] sumX = { 0 };
		int[] sumY = { 0 };

		points.forEach(p -> {
			sumX[0] += p.x;
			sumY[0] += p.y;
		});

		avgX = avgX / points.size();
		avgY = avgY / points.size();

		Point avgP = new Point(avgX, avgY);

		Set<Point> outPoints = points.stream()
				.filter(p -> Math.sqrt(Math.pow(avgP.x - p.x, 2) + Math.pow(avgP.y - p.y, 2)) > R)
				.collect(Collectors.toSet());

		return outPoints;
	}

}
