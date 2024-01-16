package test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class MainTrain2 {

	public static void main(String[] args) throws Exception{
		
		PrintWriter out=new PrintWriter(new FileWriter("test.txt"));
		out.println("hello    world  world");
		out.println(" world  \t good by");
		out.close();
		
		List<String> words=Arrays.asList("hello","world");
		int[] count=Q2.getCount(words, "test.txt");
		
		if(count[0]!=1)
			System.out.println("wrong count per some word (-16)");

		if(count[1]!=3)
			System.out.println("wrong count per some word (-17)");
		
		System.out.println("done");
		
	}

}
