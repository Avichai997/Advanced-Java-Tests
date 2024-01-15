package test;

public class MainTrain2 {

	public static void main(String[] args) {
		

		try {
			test1();
		}catch(Exception e) {
			System.out.println("your answer for q2a ran into exception (-20)");
		}
		try {
			test2();
		}catch(Exception e) {
			System.out.println("your answer for q2b ran into exception (-20)");
		}
		
		System.out.println("done");
	}

	private static void test2() {
		Employee e1 = new EmployeeBuilder().setName("abc").setAge(2).setSalary(345).build();
		Employee e2 = new EmployeeBuilder().setName("abc").setAge(2).setSalary(345).build();
		Employee e3 = new EmployeeBuilder().setName("abc").setAge(23).setSalary(45).build();
		
		if(e1!=e2)
			System.out.println("wrong result for q2b (-5)");
		if(e1==e3 || e2==e3)
			System.out.println("wrong result for q2b (-5)");
		
		Employee dummy=Employee.generate();
		Employee e4 = new EmployeeBuilder().setName(dummy.name).setAge(dummy.age).setSalary(dummy.salary).build();
		for(int i=0;i<10;i++) {
			Employee e5 = new EmployeeBuilder().setName(dummy.name).setAge(dummy.age).setSalary(dummy.salary).build();
			if(e4!=e5)
				System.out.println("wrong result for q2b (-1)");
		}
		
	}

	private static void test1() {
		Employee dummy=Employee.generate();
		
		Employee e=new EmployeeBuilder().build();
		
		if(e.age!=18 || e.salary!=10000 || !e.name.equals("default"))
			System.out.println("wrong default init for employee (-5)");
		
		Employee e1=new EmployeeBuilder().setName(dummy.name).build();
		
		if(e1.age!=18 || e1.salary!=10000 || !e1.name.equals(dummy.name))
			System.out.println("wrong result for employee (-5)");
		
		Employee e2=new EmployeeBuilder().setAge(dummy.age).setName(dummy.name).build();
		
		if(e2.age!=dummy.age || e2.salary!=10000 || !e2.name.equals(dummy.name))
			System.out.println("wrong result for employee (-5)");
		
		Employee e3=new EmployeeBuilder().setAge(dummy.age).setName(dummy.name).setSalary(dummy.salary).build();
		
		if(e3.age!=dummy.age || e3.salary!=dummy.salary || !e3.name.equals(dummy.name))
			System.out.println("wrong result for employee (-5)");
		
	}
}
