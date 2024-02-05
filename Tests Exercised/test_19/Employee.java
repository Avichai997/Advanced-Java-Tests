package test_19;

import java.util.Random;

public class Employee {

	public final String name;
	public final int age;
	public final double salary;
	
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	private static Random r=new Random();
	public static Employee generate() {
		StringBuilder sb=new StringBuilder();
		int len=5+r.nextInt(10);
		for(int i=0;i<len;i++)
			sb.append((char)('a'+r.nextInt('c'+1-'a')));
		return new Employee(sb.toString(), 30+r.nextInt(41), 10000+r.nextInt(30000));
		
	}
}
