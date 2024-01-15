package test;

import java.util.HashSet;
import java.util.List;

public class MainTrain {
	
	public static void test1(){
		HashSet<String> ignor=new HashSet<>();
		ignor.add("the");
		ignor.add("is");
		ignor.add("of");
		ignor.add("a");
		ignor.add("to");
		
		WordCounter wc=new WordCounter("data/file1.txt",ignor);
		
		if(wc.getCount("the")!=0)
			System.out.println("you counted a word that should be ignored (-5)");
		if(wc.getCount("execute")!=1)
			System.out.println("you did not count right a word (-5)");
		if(wc.getCount("source")!=3)
			System.out.println("you did not count right a word (-5)");
		if(wc.getCount("code")!=10)
			System.out.println("you did not count right a word (-5)");

		int counts[]={10,8,7};
		String words[]={"code","and","be"};
		
		List<String> o=wc.getOrderedList();
		for(int i=0;i<3;i++)
			if(!words[i].equals(o.get(i)) || counts[i]!=wc.getCount(o.get(i)))
				System.out.println("wrong word or count in the ordered list (-10)");
	}
	
	public static void test2(){
		MyPriorityQueue q=new MyPriorityQueue();
		q.add(new A(5));
		q.add(new A(7));
		q.add(new A(2));
		q.add(new A(4));
		q.add(new A(6));
		q.add(new A(11));
		q.add(new A(10));
		
		A a1=new A(3);
		A a2=new A(9);
		A a3=new A(1);
		
		q.add(a1);
		q.add(a2);
		q.add(a3);
		
		a1.setState(8);
		a2.setState(1);
		a3.setState(13);
		// the queue should automatically reposition a1, a2, a3
		
		int arr[]={1,2,4,5,6,7,8,10,11,13};
		int i=0;
		while(!q.isEmpty()){
			if(q.poll().getState()!=arr[i])
				System.out.println("priority queue order error (-5)");
			i++;
		}
	}

	public static void main(String[] args) {
		test1();
		test2();
		System.out.println("done");
	}

}
