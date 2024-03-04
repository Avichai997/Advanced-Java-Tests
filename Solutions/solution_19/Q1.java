package solution_19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import test_19.Employee;

public class Q1 {

	public static Map<Integer, Map<Character, List<Employee>>> a(Stream<Employee> s) {
		Map<Integer, Map<Character, List<Employee>>> r = new HashMap<>();
		s.sorted((e1, e2) -> (int) (e1.salary - e2.salary))
				.collect(Collectors.groupingBy(e -> e.age))
				.forEach((a, l) -> r.put(a, l.stream().collect(Collectors.groupingBy(e -> e.name.charAt(0)))));
		return r;
	}

	public static boolean b(Stream<Employee> s, int age, char c) {
		return s.filter(e -> e.age > age).noneMatch(e -> e.name.charAt(e.name.length() - 1) == c);
	}

	public static Employee c(Stream<Employee> s) {
		return s.max((e1, e2) -> e1.name.compareTo(e2.name)).get();
	}

}
