package test;



public class MainTrain {

	public static void test1(){
		if(American.q1()<'a' || American.q1()>'d')
			System.out.println("you didn't answer q1");
		if(American.q2()<'a' || American.q2()>'d')
			System.out.println("you didn't answer q2");
		if(American.q3()<'a' || American.q3()>'d')
			System.out.println("you didn't answer q3");
		if(American.q4()<'a' || American.q4()>'d')
			System.out.println("you didn't answer q4");
		if(American.q5()<'a' || American.q5()>'d')
			System.out.println("you didn't answer q5");
		if(American.q6()<'a' || American.q6()>'d')
			System.out.println("you didn't answer q6");
		if(American.q7()<'a' || American.q7()>'d')
			System.out.println("you didn't answer q7");
		if(American.q8()<'a' || American.q8()>'d')
			System.out.println("you didn't answer q8");
		if(American.q9()<'a' || American.q9()>'d')
			System.out.println("you didn't answer q9");
		if(American.q10()<'a' || American.q10()>'d')
			System.out.println("you didn't answer q10");
		
		
	}

	

	public static StringBuilder sb;
	public static void func(Event invoker, Object about){
		sb.append("func was invoked by "+invoker);
		if(about!=null){
			sb.append("this is about "+about);
		}
	}
	
	public static void test2(){
		if(Event.class.getInterfaces().length>0 || !Event.class.getSuperclass().equals(Object.class))
			System.out.println("the Event class should not extend or implement any types (-15)");
		
		Event e1=new Event("E1");
		Event e2=new Event("E2");
		
		sb=new StringBuilder();
		e1.addDelegate((i,a)->func(i,a));
		e1.apply(); // output: func was invoked by E1
		
		if(!sb.toString().equals("func was invoked by E1"))
			System.out.println("failed to apply a single delegate with no parameters (-5)");
		
		sb=new StringBuilder();
		e1.apply("hello world!"); // output:
									//func was invoked by E1
									//this is about hello world!
		if(!sb.toString().equals("func was invoked by E1this is about hello world!"))
			System.out.println("failed to apply a single delegate with a parameter (-5)");
		
		sb=new StringBuilder();
		e2.addDelegate((i,a)->func(i,a));
		e2.apply(); // output: func was invoked by E2
		if(!sb.toString().equals("func was invoked by E2"))
			System.out.println("failed to apply a single delegate with no parameters for another Event (-5)");
		
		sb=new StringBuilder();
		e1.addDelegate((i,a)->sb.append("just another event handler"));
		e1.bindTo(e2);
		e2.apply(); // output:
						//func was invoked by E2
						//func was invoked by E1
						//just another event handler
		if(!sb.toString().equals("func was invoked by E2func was invoked by E1just another event handler"))
			System.out.println("failed to bind events and/or apply multiple delegates (-10)");		
	}
	
	public static void main(String[] args) {
		test1();
		test2();
		System.out.println("done");
	}
}
