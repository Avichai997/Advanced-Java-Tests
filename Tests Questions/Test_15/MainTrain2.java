package test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTrain2 {

	public static void main(String[] args) throws Exception{
		
		PrintWriter out=new PrintWriter(new FileWriter("test.txt"));
		out.println("hello    world  world");
		out.println(" world  \t good by");
		out.close();
		
		Q2.writeWords("test.txt", "test_a.txt");
		
		Stream<String> s=Files.lines(Paths.get("test_a.txt"));
		List<String> l=s.collect(Collectors.toList());
		s.close();
		
		if(!l.get(0).equals("world") || !l.get(1).equals("by") || !l.get(2).equals("good")|| !l.get(3).endsWith("hello"))
			System.out.println("the output file is wrong (-33)");
		
		System.out.println("done");
		
	}

}
