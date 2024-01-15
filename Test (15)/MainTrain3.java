package test;

public class MainTrain3 {

	public static void main(String[] args) {
		
		if(!new MyStringBuilder('a','b','c').toString().equals("abc")) {
			System.out.println("wrong implementation of toString (-5)");
			System.out.println("please fix. this affects the other tests (-20)");
		}else {
		
			if(!new MyStringBuilder().append("abc").toString().equals("abc"))
				System.out.println("wrong implementation of append (-5)");
	
			if(!new MyStringBuilder('a','b','c').reverse().toString().equals("cba"))
				System.out.println("wrong implementation of reverse (-5)");
			
			if(!new MyStringBuilder('a','b','c').apply(c->(char)(c-('a'-'A'))).toString().equals("ABC"))
				System.out.println("wrong implementation of apply (-10)");
		}
		// all together
		MyStringBuilder sb=new MyStringBuilder();
		String s = sb.append("abc").append("def").reverse()
				.apply(c->(char)(c-('a'-'A'))).toString();
		
		System.out.println(s); // FEDCBA
		
		System.out.println("done");
	}

}
