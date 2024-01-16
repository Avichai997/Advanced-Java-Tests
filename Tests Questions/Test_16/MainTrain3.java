package test;

public class MainTrain3 {

	public static void main(String[] args) {
		
		if(new MyIntegerBuilder('1','2','3').toInt()!=123) {
			System.out.println("wrong implementation of toInt (-5)");
			System.out.println("please fix. this affects the other tests (-18)");
		}else {
		
			try {
				if(new MyIntegerBuilder().append("123").toInt()!=123)
					System.out.println("wrong implementation of append (-5)");
			} catch (Exception e) {
				System.out.println("append threw an exception when not needed(-5)");
			}

			boolean ex=false;
			try {
				new MyIntegerBuilder().append("123 ");
			} catch (Exception e) {
				ex=true;
				if(!e.getMessage().equals("the string must digits an only digits"))
					System.out.println("wrong message for the thrown exception (-8)");
			}
			if(!ex)
				System.out.println("append did not throw an exception when needed (-8)");
			
	
			if(new MyIntegerBuilder('1','2','3').reverse().toInt()!=321)
				System.out.println("wrong implementation of reverse (-5)");
			
		}
		
		try{
			MyIntegerBuilder ib=new MyIntegerBuilder();
			int i = ib.append("123").append("456").reverse().toInt();
			System.out.println(i); // 654321
		}catch(Exception e){}

		
		System.out.println("done");
	}

}
