package test_19;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MainTrain3 {

	public static void main(String[] args) {
		String CNF = "(A == 5) AND (B <= 3 OR C<=10) AND (x ==10 OR eli==40 OR jhkgfjhg <=1000)";
		
		Predicate<Map<String,Integer>> p = Interpreter.interpret(CNF);
		
		Map<String,Integer> symTable=new HashMap<String, Integer>();
		symTable.put("A", 5);
		symTable.put("B", 2);
		symTable.put("C", 10);
		symTable.put("x", 10);
		symTable.put("eli", 40);
		symTable.put("jhkgfjhg", 999);
		
		if(!p.test(symTable))
			System.out.println("wrong result for symTable1 (-10)");
		
		
		symTable.put("A", 4);
		
		if(p.test(symTable))
			System.out.println("wrong result for symTable2 (-10)");
		
		symTable.put("A", 5);
		symTable.put("x", 11);
		symTable.put("eli", 41);
		symTable.put("jhkgfjhg", 999);
		if(!p.test(symTable))
			System.out.println("wrong result for symTable3 (-10)");
		
		System.out.println("done");
	}

}
