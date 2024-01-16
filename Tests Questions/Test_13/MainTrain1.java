package test;

import java.util.Random;

public class MainTrain1 {

	public static void main(String[] args) {
		ListBuilder<Integer> lb=new ListBuilder<>();
		
		// a simple test to get you going
		ImmutableList<Integer> list = lb.push(4).push(3).push(2).push(1).build();
		// list is: 1,2,3,4
		int sum[]= {0};
		ListBuilder.forEach(list, e->{sum[0]*=10;sum[0]+=e;});
		// sum=1234
		if(sum[0]!=1234)
			System.out.println("you got a wrong list check push and forEach (-5)");

		lb=new ListBuilder<>();
		
		
		list = lb.push(4).push(3).push(2).push(1).reverse().push(5).build();
		// list is: 5,4,3,2,1
		sum[0]=0;
		ListBuilder.forEach(list, e->{sum[0]*=10;sum[0]+=e;});
		// sum=54321
		if(sum[0]!=54321)
			System.out.println("you got a wrong list check push reverse and forEach (-5)");
		
		
		// now for 8 randomized tests...
		Random r=new Random();
		for(int i=0;i<8;i++) {
			long sumr=0;
			lb=new ListBuilder<>();
			for(int j=0;j<3+r.nextInt(50);j++) {
				int x=1+r.nextInt(10);
				lb.push(x);
				sumr*=10;
				sumr+=x;
			}
			lb.reverse();
			long sumrr[]= {0};
			ListBuilder.forEach(lb.build(), e->{sumrr[0]*=10;sumrr[0]+=e;});
			if(sumrr[0]!=sumr)
				System.out.println("you got a wrong list (-5)");
		}
		
		System.out.println("done");
	}

}
