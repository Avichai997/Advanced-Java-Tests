package test11;

import java.util.HashMap;

public class EucDistProxy implements DistCalculator {
	public static HashMap<String, Double> calcs;
	EuclideanDist ed;

	public EucDistProxy() {
		calcs = new HashMap<>();
		ed = new EuclideanDist();
	}

	@Override
	public double distance(Point p1, Point p2) {
		String key1 = p1.toString() + ", " + p2.toString();
		String key2 = p2.toString() + ", " + p1.toString();

		if (calcs.containsKey(key1))
			return calcs.get(key1);
		if (calcs.containsKey(key2))
			return calcs.get(key2);
		
		Double result = ed.distance(p1, p2);
		calcs.put(key1, result);
//		calcs.put(key2, result);
		return result;
	}
}
