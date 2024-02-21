package solutions11;

import java.util.HashMap;

public class EucDistProxy implements DistCalculator {

	HashMap<String, Double> results;
	EuclideanDist ed;

	public EucDistProxy() {
		results = new HashMap<>();
		ed = new EuclideanDist();
	}

	@Override
	public double distance(Point p1, Point p2) {
		String k1 = p1.toString() + p2.toString();
		String k2 = p2.toString() + p1.toString();

		if (results.containsKey(k1))
			return results.get(k1);
		if (results.containsKey(k2))
			return results.get(k2);

		double result = ed.distance(p1, p2);
		results.put(k1, result);
		return result;
	}

}
