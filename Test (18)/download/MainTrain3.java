package test;

public class MainTrain3 {
	
	public static void test(String id,int cd) {
		try {
			if(Q3.calcMissingDigit(id)!=cd)
				System.out.println("wrong check id (-8)");
		}catch(Exception e) {
			System.out.println("your code has thrown an exception (-8)");
		}
	}

	public static void main(String[] args) {
		
		test("_23456782",1);
		test("87_543216",6);
		test("246_13570",8);
		test("1257346_1",8);		

		
		System.out.println("done");
	}

}
