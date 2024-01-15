package test;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainTrain2 {

	public static void check(Map<Character,List<String>> map, char c, int i, String word) {
		try {
			if(!map.get(c).get(i).equals(word))
				System.out.println("your map is not in order (-2)");				
		}catch(Exception e) {
			System.out.println("your map throws an exception (-2)");
		}
	}
	
	public static void main(String[] args) {
		// check map
		List<String> words=Arrays.asList("ococ", "ppa","allb","etterb","poloa");
		try {
			Map<Character,List<String>> map=Q2.map(words.stream());
			check(map, 'a',0,"ppa");
			check(map, 'a',1,"poloa");
			check(map, 'b',0,"allb");
			check(map, 'b',1,"etterb");
			check(map, 'c',0,"ococ");
		}catch(Exception e) {
			System.out.println("your map throws an exception (-11)");
		}
		
		// check total
		try {
			List<String> log=Arrays.asList("somthing", "bl","bla","Error: not Found","apolo"," ");
			if(Q2.total(log.stream())!=(8*3*16*5))
				System.out.println("you returned a wrong length (-11)");
		}catch(Exception e) {
			System.out.println("your totalErrorsLength throws an exception (-11)");
		}
		
		// check anomalies
		Point p1=new Point(0,6);
		Point p2=new Point(12,0);
		Point p3=new Point(0,0);
		List<Point> ps=Arrays.asList(p1,p2,p3);
		// average point is ((0+12+0)/3, (6+0+0)/3) = (4,2)
		try {			
			Set<Point> anomlies = Q2.anomalies(ps, 5);
			// (0,6) and (12,0) are outside the circle with center (4,2) and radius 5.
			if(!anomlies.contains(p1) || !anomlies.contains(p2) || anomlies.contains(p3))
				System.out.println("you returned a wrong set (-11)");
		}catch(Exception e) {
			System.out.println("your anomalies throws an exception (-11)");
		}
		
		
	
		
		System.out.println("done");
	}

}
