package test;

import java.lang.reflect.Constructor;

public class MainTrain3 {
	
	public static void q3a(){
		if(PushableAdapter.class.getInterfaces().length==0 || PushableAdapter.class.getInterfaces().length>1 ||!PushableAdapter.class.getInterfaces()[0].equals(Pushable.class))
			System.out.println("Pushable adapater should implement Pushable, and not other interfaces for question 3a  (-5)"); // 5
		Constructor c=PushableAdapter.class.getConstructors()[0];
		if(c==null)
			System.out.println("PushableAdapater has no constructor for question 3a (-10)"); // 10
		else{
			if(c.getParameterTypes().length==0 || !c.getParameterTypes()[0].equals(Moveable.class))
				System.out.println("PushableAdapater CTOR should have a Moveable as a parameter for question 3a (-10)"); // 10
		}
		// 5 points free :) I don't really need to check the IF statements of the adapter :)
	}
	
	public static void q3b(){
		AmericanQuestion aq=new AmericanQuestion();
		if(aq.q1()==null || !aq.q1().equals(aq.patterns[1]))
			System.out.println("wrong answer to q3b - q1 (-5)"); // 5
		if(aq.q2()==null || !aq.q2().equals(aq.patterns[3]))
			System.out.println("wrong answer to q3b - q2 (-5)"); // 5
		if(aq.q3()==null || !aq.q3().equals(aq.patterns[0]))
			System.out.println("wrong answer to q3b - q3 (-5)"); // 5
		if(aq.q4()==null || !aq.q4().equals(aq.patterns[6]))
			System.out.println("wrong answer to q3b - q4 (-5)"); // 5
	}
	
	public static void main(String[] args) {
		q3a();
		q3b();
		System.out.println("done");
	}

}
