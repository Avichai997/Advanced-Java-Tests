package test;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBuilder {
	public String name;
	public int age;
	public double salary;

	static Map<String, Employee> map=new HashMap<>();
	
	public EmployeeBuilder() {
		name="default";
		age=18;
		salary=10000;
	}
	
	public EmployeeBuilder setName(String name) {
		this.name=name;
		return this;
	}
	public EmployeeBuilder setAge(int age) {
		this.age=age;
		return this;
	}
	public EmployeeBuilder setSalary(double salary) {
		this.salary=salary;
		return this;
	}
	
	public Employee build() {
		String key=name+"."+age+"."+salary;
		if(map.containsKey(key))
			return map.get(key);
		Employee e=new Employee(name, age, salary);
		map.put(key, e);
		return e;
	}
	
}
