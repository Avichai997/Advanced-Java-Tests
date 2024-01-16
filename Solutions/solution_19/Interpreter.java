package test;

import java.util.Map;
import java.util.function.Predicate;

public class Interpreter {

	public static Predicate<Map<String,Integer>> interpret(String CNF) {
		return symTable-> {				
				Predicate<Map<String, Integer>> ret=x->true;
				
				for(String exp : CNF.split(" AND ")) {
					Predicate<Map<String, Integer>> ret_i=x->false;
					for(String expBool : exp.split(" OR ")) {
						String be=expBool.replace('(', ' ').replace(')', ' ');
						ret_i=ret_i.or(create(be));
					}
					ret=ret.and(ret_i);
				}
				return ret.test(symTable);
			};
	}
	
	private static Predicate<Map<String, Integer>> create(String be) {				
		return symRable ->{
				if(be.contains("==")) {
					String var=be.split("==")[0].trim();
					int val=Integer.parseInt(be.split("==")[1].trim());
					return symRable.get(var).intValue() == val;
				}
				if(be.contains("<=")) {
					String var=be.split("<=")[0].trim();
					int val=Integer.parseInt(be.split("<=")[1].trim());
					return symRable.get(var).intValue() <= val;
				}
				return false;
			};
	}
	
	
}
