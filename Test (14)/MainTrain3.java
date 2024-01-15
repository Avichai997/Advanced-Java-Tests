package test;

import java.util.List;
import java.util.Random;

public class MainTrain3 {

	public static void main(String[] args) {
		Buffer<Integer> b=new Buffer<>();
		
		List<Integer> list = b.append(5).append(4).append(3).append(2).append(1)
		.reverese().apply(x->x*2).toList();
		
		list.forEach(System.out::println);
		
		// test the code independently:
		
		b=new Buffer<>();
		Random r=new Random();
		int x=r.nextInt();
		list=b.append(x).toList();
		if(list.get(0)!=x)
			System.out.println("problem with append (-5)");
		
		b=new Buffer<>(1,2,3,4);
		list=b.reverese().toList();
		if(list.get(0)!=4 || list.get(1)!=3 || list.get(2)!=2 || list.get(3)!=1)
			System.out.println("problem with reverese (-10)");
		
		b=new Buffer<>(1,2,3,4);		
		list=b.apply(xi->xi*x).toList();
		if(list.get(0)!=x || list.get(1)!=2*x || list.get(2)!=3*x || list.get(3)!=4*x)
			System.out.println("problem with apply (-10)");
		
		System.out.println("done");
	}

}
