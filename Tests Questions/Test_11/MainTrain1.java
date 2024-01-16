package test;

public class MainTrain1 {

	public static void main(String[] args) {
		// test 1
		DistCalculator dc=new EucDistProxy();
		double r=dc.distance(new Point(0,0,0), new Point(3,4,5));
		if(r!=Math.sqrt(50))
			System.out.println("wrong result (-10)");
		
		if(EuclideanDist.getInvokes()!=1)
			System.out.println("wrong implementation of Proxy Pattern (-10)");
		
		// test 2
		r=dc.distance(new Point(0,0,0), new Point(3,4,5));
		if(r!=Math.sqrt(50))
			System.out.println("wrong result (-10)");
		
		if(EuclideanDist.getInvokes()!=1)
			System.out.println("wrong implementation of the instructions (-10)"); 
		
		//test 3
		r=dc.distance(new Point(3,4,5), new Point(0,0,0));
		if(r!=Math.sqrt(50) || EuclideanDist.getInvokes()!=1)
			System.out.println("wrong implementation of the instructions (-20)");
		
		System.out.println("done");
	}

}
