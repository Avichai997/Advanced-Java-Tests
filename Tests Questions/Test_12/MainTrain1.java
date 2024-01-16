package test;

import java.util.HashMap;
import java.util.Random;

public class MainTrain1 {

	public static void main(String[] args) {
		
		// generate a random simple key:
		Random r=new Random();
		int x=1+r.nextInt(255);
		HashMap<Character,Character> simpleKey=new HashMap<>();
		for(char e=0;e<256;e++){
			char d = (char)((e+x)%256);
			simpleKey.put(e, d);
		}
		
		String msg="Hello World!";
		Encoder encoder1=new Encoder(simpleKey); // simple hashmap key
		String e1=encoder1.encode(msg);
		
		if(!(completlyNotEqual(msg,e1) && encoder1.decode(e1).equals(msg)))
			System.out.println("wrong implementation of the encoder with hash key (-25)");
		
		final int y=10+r.nextInt(246);
		Encoder encoder2=new Encoder(e->(char)((e+y)%256)); // lambda function for encryption
		String e2=encoder2.encode(msg);
		
		if(!(completlyNotEqual(msg,e2) && encoder2.decode(e2).equals(msg)))
			System.out.println("wrong implementation of the encoder with lambda function (-25)");

		System.out.println("done");
	}

	private static boolean completlyNotEqual(String a, String b) {
		boolean ne=true;
		for(int i=0;i<a.length() && ne;i++){
			ne=a.charAt(i)!=b.charAt(i);
		}
		return ne;
	}

}
