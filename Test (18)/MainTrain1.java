package test;

public class MainTrain1 {

	public static void main(String[] args) {
		Smurf s1=new Smurf();
		Smurf s2=new Smurf();
		Smurf s3=new Smurf();
		Smurf s4=new Smurf();
		
		s1.worksWhen(s2,s3); // s1 works if either s2 or s3 are working
		s2.worksWhen(s1,s3,s4); // s2 works if either s1,s3 or s3 are working
		s3.worksWhen(s1); // notice the circle s1<->s3
		
		if(s1.isWorking() || s2.isWorking() || s3.isWorking() || s4.isWorking())
			System.out.println("no one should be working at this stage (-10)");
		
		s1.work(); // this should trigger s3 and s2 to work
		// when s3 is working, beware of an infinite loop, s1 already works.
		
		if(!s1.isWorking())
			System.out.println("s1 should be working (-4)");
		if(!s2.isWorking())
			System.out.println("s2 should be working because of s1 (-8)");
		if(!s3.isWorking())
			System.out.println("s3 should be working because of s1 (-8)");
		if(s4.isWorking())
			System.out.println("s4 should not be working (-5)");
		
		System.out.println("done");
	}

}
