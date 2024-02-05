package solution_20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmpTable {

	public static String getTable(List<Employee> emps) {
		StringBuilder sb = new StringBuilder("name\tage\tsalary\n");
		for (Employee e : emps) {
			sb.append(e.getName() + "\t" + e.getAge() + "\t" + e.getSalary() + "\n");
		}
		return sb.toString();
	}

	public static List<Employee> getEmps(String table) {
		ArrayList<Employee> emps = new ArrayList<>();
		String[] lines = table.split("\n");
		for (int i = 1; i < lines.length; i++) {
			String feilds[] = lines[i].split("\t");
			emps.add(new Employee(feilds[0], Integer.parseInt(feilds[1]), Double.parseDouble(feilds[2])));
		}
		return emps;
	}

	public static List<Employee> query(String table, Predicate<Employee> p) {
		return getEmps(table).stream().filter(p).collect(Collectors.toList());
	}

	public static String intersection(String table1, String table2) {
		List<Employee> t1 = getEmps(table1);
		List<Employee> t2 = getEmps(table2);
		t1.retainAll(t2);
		return getTable(t1);
	}
}
