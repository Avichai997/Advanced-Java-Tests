package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	public static void writeWords(String source, String destination) {
		try {
			HashMap<String, Integer> map=new HashMap<>();
			Scanner s=new Scanner(new BufferedReader(new FileReader(source)));
			while(s.hasNext()) {
				String w=s.next();
				if(!map.containsKey(w))
					map.put(w, 1);
				else
					map.put(w, map.get(w)+1);
			}
			s.close();
			
			List<String>  l=new ArrayList<>();
			l.addAll(map.keySet());
			
			l.sort((s1,s2)->{
				int x=map.get(s2) - map.get(s1);
				if(x==0)
					x=s1.compareTo(s2);
				return x;
			});
			
			PrintWriter out=new PrintWriter(new FileWriter(destination));
			l.forEach(si->out.println(si));
			out.close();
			
		} catch (IOException e) {}
	}
}
