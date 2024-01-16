package test;

import java.util.Collections;
import java.util.LinkedList;

public class MainTrain1 {
	

	public static void main(String[] args) {
		Task a=new Task(11,100,"A");
		Task b=new Task(11,100,"B");
		Task c=new Task(10,101,"C");
		Task d=new Task(10,100,"D");

		LinkedList<Task> tasks=new LinkedList<>();
		tasks.add(a);
		tasks.add(b);

		Collections.sort(tasks); // compilation error if Task is not Comparable -15.
		
		if(a.compareTo(b)>=0)
			System.out.println("priority mistake comparing names (-4)"); // 4 
		
		if(b.compareTo(d)>=0)
			System.out.println("priority mistake comparing frequencies (-4)"); // 4
		
		if(d.compareTo(c)>=0)
			System.out.println("priority mistake comparing durations (-4)"); // 4
		
		if(a.compareTo(a)!=0)
			System.out.println("priority mistake comparing equal tasks (-3)"); // 3


		if(!(MyAdapter.class.getInterfaces().length==1 && MyAdapter.class.getInterfaces()[0].equals(Runnable.class)))
			System.out.println("MyAdapter is not Runnable or implements more than one interface (-5)"); //- 5
		
		if(!MyAdapter.class.getSuperclass().equals(MyPlayer.class))
			System.out.println("MyAdpater does not extend MyPlayer (-10)"); // -10

		// this might get compilation error if no default CTOR or not Runnable -5  
		MyAdapter ma=new MyAdapter();
		ma.run();
		if(!MyAdapter.test.equals("stoprewindplay"))
			System.out.println("run() is not implemented correctly (-5)"); // -5

		
		System.out.println("done");
	}

}
