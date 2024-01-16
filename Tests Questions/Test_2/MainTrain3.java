package test;

import java.util.Comparator;

public class MainTrain3 {
	
	static class MyCommand implements Command{
		@Override
		public void execute() {/*...*/}	
		int getSomePriority(){ /*...*/ return 0; }
	}

	// won't compile if problem is not solved -10 points
	public static void main(String[] args) {
		
		Controller<MyCommand> c=new Controller<MyCommand>(new Comparator<MyCommand>() {
			@Override
			public int compare(MyCommand o1, MyCommand o2) {
				return o1.getSomePriority()-o2.getSomePriority();
			}
		});
		
		c.insertCommand(new MyCommand());
		c.executeOne();
		
		
		AmericanQuestion aq=new AmericanQuestion();
		if(!aq.q1().equals(aq.principles[2]))
			System.out.println("american question q1 is wrong (-5)"); // 5
		if(!aq.q2().equals(aq.principles[7]))
			System.out.println("american question q2 is wrong (-5)"); // 5
		if(!aq.q3().equals(aq.principles[0]))
			System.out.println("american question q3 is wrong (-5)"); // 5
		if(!(aq.q4().equals(aq.principles[8]) || aq.q4().equals(aq.principles[0]) ))
			System.out.println("american question q4 is wrong (-5)"); // 5
		
		System.out.println("done");
	}

}
