package test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1 {

	
	public static double a(Stream<Employee> s){
		List<Double> sals=s.map(e->e.getSalary()).sorted((s1,s2)->(int)(s1-s2)).collect(Collectors.toList());
		return sals.get(sals.size()/2);
	}
	
	public static List<Employee> b(List<Employee> l){
		double avg=l.stream().mapToDouble(e->e.getSalary()).average().getAsDouble();
		return l.stream().filter(e->e.getSalary()>avg).sorted((e1,e2)->e1.getAge()-e2.getAge()).collect(Collectors.toList());
	}
	
	public static Employee c(Stream<Employee> s) {
		return s.filter(e->e.getName().startsWith("a")).max((e1,e2)->(int)(e1.getSalary() - e2.getSalary())).get();
	}
	
}
