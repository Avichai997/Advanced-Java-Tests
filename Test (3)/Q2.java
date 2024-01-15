package test;

import java.util.HashSet;

public class Q2 {

	public static interface StringReader{
		String readString();
	}
	
	public static class MyWordFilter { // Decorator

	}
	
	public static interface IntArrayReader{
		int[] readIntArray();
	}
	
	public static class MyIntArrayToStringReader { // Object Adapter
		
	}
	

	// ---------------------- test API ------------------------------
	
	public static class MyStringReader implements StringReader{
		@Override
		public String readString() {
			return "Hello Hello World World Q2";
		}
	}
	
	public static class MyIntArrayReader implements IntArrayReader{
		@Override
		public int[] readIntArray() {
			int[] r={100,100,50,50,13,14};
			return r;
		}
	}
	
	public static void testAPI(){
		StringReader reader=new MyWordFilter(new MyStringReader());
		System.out.println(reader.readString()); // Hello;World;Q2;
		
		reader=new MyWordFilter(new MyIntArrayToStringReader(new MyIntArrayReader()));
		System.out.println(reader.readString()); // 100;50;13;14;
	}
}
