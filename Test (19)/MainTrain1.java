package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainTrain1 {

	
	public static void main(String[] args) {
		List<Employee> l=new ArrayList<Employee>();
		String maxName="";
		for(int i=0;i<1000;i++) {
			Employee e=Employee.generate();
			l.add(e);
			if(maxName.compareTo(e.name)<0)
				maxName=e.name;				
		}
		
		test1(l);
		test2(l);
		test3(l,maxName);
		
		System.out.println("done");
	}

	private static void test3(List<Employee> l, String maxName) {
		try {
			Employee e=Q1.c(l.stream());
			if(!e.name.equals(maxName))
				System.out.println("wrong result for Q1c (-5)");
		}catch(Exception e) {
			System.out.println("your code for Q1c ran into excpetion (-5)");
		}
	}

	private static void test2(List<Employee> l) {
		try {
			Random r=new Random();
			Employee emp=l.get(r.nextInt(l.size()));
			String name=emp.name;
			int age=emp.age;
			char c=name.charAt(name.length()-1);
			if(Q1.b(l.stream(), age-1, c))
				System.out.println("wrong result for Q1b (-5)");
			if(!Q1.b(l.stream(), age-1, 'e'))
				System.out.println("wrong result for Q1b (-5)");
		}catch(Exception e) {
			System.out.println("your code for Q1b ran into excpetion (-10)");			
		}
		
	}

	private static void test1(List<Employee> l) {
		try {
			Map<Integer, Map<Character, List<Employee>>> m=Q1.a(l.stream());
			if(m==null || m.size()==0) {
				System.out.println("you returned an empty result (-15)");
			}else {
				boolean[] fault= {false};
				m.forEach((a,mcl)->{
					if(mcl==null || mcl.size()==0) {
						fault[0]=true;						
					}else {
						mcl.forEach((c,le)->{
							double sal=-1;
							for(Employee e : le) {
								if(e.name.charAt(0)!=c.charValue() || e.salary<sal) {
									fault[0]=true;
									break;
								}
								sal=e.salary;
							}
						});
					}
				});
				if(fault[0])
					System.out.println("your code didn't return the desired result (-15)");
			}
		}catch(Exception e) {
			System.out.println("your code for Q1a ran into excpetion (-15)");
		}
	}
}
