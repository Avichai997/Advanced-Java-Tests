package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q3 {

	public static int getCheckDigit(String id) {
		int sum=0;
		int i=1;
		for(char c: id.toCharArray()){
			int x=i*(c-'0');
			if(x>=10) //e.g. 14
				x=1+x%10;	// 1 + 4
			sum+=x;
			i=2-(i+1)%2; // alternate between 1 and 2
		}
		return (sum%10>0?10-sum%10:0);
	}

	public static boolean wrongID(String id){
		int cd=getCheckDigit(id.substring(0, 8));
		return cd!=id.charAt(8) - '0';
	}
	
	public static List<String> checkFile(String fileName){
		try {			
			Stream<String> s=Files.lines(Paths.get(fileName));
			List<String> r=s.filter(id->wrongID(id)).collect(Collectors.toList());
			s.close();
			return r;
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return null;
	}
}
