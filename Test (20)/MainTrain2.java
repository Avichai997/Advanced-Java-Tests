package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTrain2 {
	
	
	public static void main(String[] args) {
		Random r=new Random();
		ArrayList<Employee> emps=new ArrayList<>();
		emps.add(new Employee(""+r.nextInt(1000), 18+r.nextInt(60), 10000.5 + r.nextInt(30000)));
		emps.add(new Employee(""+r.nextInt(1000), 18+r.nextInt(60), 10000.5 + r.nextInt(30000)));
		emps.add(new Employee(""+r.nextInt(1000), 18+r.nextInt(60), 10000.5 + r.nextInt(30000)));
		
		String table = EmpTable.getTable(emps);
		String exp=	"name	age	salary\n"+
				emps.get(0).getName()+"\t"+emps.get(0).getAge()+"\t"+emps.get(0).getSalary()+"\n" + 
				emps.get(1).getName()+"\t"+emps.get(1).getAge()+"\t"+emps.get(1).getSalary()+"\n" + 
				emps.get(2).getName()+"\t"+emps.get(2).getAge()+"\t"+emps.get(2).getSalary()+"\n";
		
		if(!exp.equals(table))
			System.out.println("getTable didn't return the correct table string (-10)");
		
		
		emps=new ArrayList<>();
		for(int i=0;i<100;i++)
			emps.add(Employee.generate());
		
		table = EmpTable.getTable(emps);		
		
		List<Employee> emps2=EmpTable.getEmps(table);
		if(emps2==null || emps2.size()!=emps.size())
			System.out.println("wrong list size returned by getEmps (-10)");
		else {
			boolean ok=true;
			for(int i=0;i<emps.size() && ok;i++) {
				if(!emps.get(i).equals(emps2.get(i)))
					ok=false;
			}
			if(!ok)
				System.out.println("you didn't return the correct list from the table (-10)");
		}
		
		List<Employee> ans=EmpTable.query(table, e->e.getName().startsWith("a"));
		boolean ok=true;
		for(Employee e : ans)
			if(!e.getName().startsWith("a")) {
				ok=false;
				break;
			}
		if(!ok)
			System.out.println("wrong answer to table query (-5)");
		
		ans=EmpTable.query(table, e->e.getAge()>20);
		ok=true;
		for(Employee e : ans)
			if(e.getAge()<=20) {
				ok=false;
				break;
			}
		if(!ok)
			System.out.println("wrong answer to table query (-5)");			
		
		
		String table1=	"name	age	salary\n"+
				"abc	18	10000.0\n"+
				"xyz	25	12000.0\n"+
				"ABC	32	25000.0\n";

		String table2=	"name	age	salary\n"+
				"abc	18	10000.0\n"+
				"XYZ	32	25000.0\n"+
				"xyz	25	12000.0\n";

		String table3=	"name	age	salary\n"+
				"abc	18	10000.0\n"+
				"xyz	25	12000.0\n";
		
		String st=EmpTable.intersection(table1, table2);

		if(!table3.equals(st))
			System.out.println("problem with intersection result (-10)");
		
		System.out.println("done");
		System.out.println(table1);
	}

}
