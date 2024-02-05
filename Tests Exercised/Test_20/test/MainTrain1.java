package test;

import java.util.ArrayList;
import java.util.List;

public class MainTrain1 {

	
	private static double avg=0;
	private static int c=0;
	private static double max=0;
	
	public static void main(String[] args) {
		List<Employee> l=new ArrayList<Employee>();
		for(int i=0;i<1000;i++) {
			Employee e=Employee.generate();
			avg+=e.getSalary();
			l.add(e);
		}
		avg/=l.size();
		l.forEach(e->{
			if(e.getSalary()>avg)
				c++;
			if(e.getName().startsWith("a") && max<e.getSalary())
				max=e.getSalary();
		});
		
		test1(l);
		test2(l);
		test3(l);
		
		System.out.println("done");
	}

	private static void test3(List<Employee> l) {
		try {
			Employee e=Q1.c(l.stream());
			if(!e.getName().startsWith("a") || e.getSalary()!=max)
				System.out.println("wrong answer for Q1c (-10)");
		}catch(Exception e) {
			System.out.println("your code for Q1c ran into excpetion (-10)");
		}
	}

	private static void test2(List<Employee> l) {
		try {
			List<Employee> h=Q1.b(l);
			if(h.size()!=c)
				System.out.println("list size returned by Q1b is incorrect (-5)");
			boolean b=true;
			int lastAge=-1;
			for(Employee e : h) {
				if(e.getSalary()<=avg || lastAge>e.getAge()) {
					b=false;
					break;					
				}
				lastAge=e.getAge();
			}
			if(!b)
				System.out.println("incorrect list returned by Q1b (-5)");
			
		}catch(Exception e) {
			System.out.println("your code for Q1b ran into excpetion (-10)");			
		}
		
	}

	private static void test1(List<Employee> l) {
		try {
			double mid=Q1.a(l.stream());
			int countBellow=0,countAbove=0;
			for(Employee e : l) {
				if(e.getSalary()>=mid)
					countAbove++;
				else
					countBellow++;
			}
			if(countAbove!=countBellow)
				System.out.println("Q1a didn't return the correct answer (-10)");
		}catch(Exception e) {
			System.out.println("your code for Q1a ran into excpetion (-10)");
		}
	}
}
