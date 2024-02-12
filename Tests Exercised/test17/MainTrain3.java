// package test17;

// import java.util.List;

// import Q3;

// public class MainTrain3 {

// 	public static void test(String id, int cd) {
// 		try {
// 			if (Q3.getCheckDigit(id) != cd)
// 				System.out.println("wrong check id (-4)");
// 		} catch (Exception e) {
// 			System.out.println("your code has thrown an exception (-4)");
// 		}
// 	}

// 	public static void main(String[] args) {

// 		test("12345678", 2);
// 		test("87654321", 6);
// 		test("24681357", 0);
// 		test("12573468", 1);

// 		try {
// 			List<String> ids = Q3.checkFile("ids.txt");
// 			if (ids == null || ids.size() != 4)
// 				System.out.println("you returned a wrong size of list (-16)");
// 			else {
// 				if (!ids.get(0).equals("213664864"))
// 					System.out.println("wrong id returned (-4)");
// 				if (!ids.get(1).equals("015628687"))
// 					System.out.println("wrong id returned (-4)");
// 				if (!ids.get(2).equals("028631777"))
// 					System.out.println("wrong id returned (-4)");
// 				if (!ids.get(3).equals("032789423"))
// 					System.out.println("wrong id returned (-4)");
// 			}
// 		} catch (Exception e) {
// 			System.out.println("your code has thrown an exception (-16)");
// 		}

// 		System.out.println("done");
// 	}

// }
