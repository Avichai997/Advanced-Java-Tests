package test;

import java.util.HashSet;

public class Q2 {

	public static interface StringReader{
		String readString();
	}
	
	public static class MyWordFilter implements StringReader{

		StringReader reader;
		
		public MyWordFilter(StringReader reader) {
			this.reader=reader;
		}
		
		@Override
		public String readString() {
			String sp[]=reader.readString().split(" ");
			HashSet<String> hash=new HashSet<>();
			for(String s : sp)
				hash.add(s);
			
			StringBuilder sb=new StringBuilder();
			for(String s : sp){
				if(hash.contains(s)){
					sb.append(s+";");
					hash.remove(s);
				}
			}
			return sb.toString();
		}				
	}
	
	public static interface IntArrayReader{
		int[] readIntArray();
	}
	
	public static class MyIntArrayToStringReader implements StringReader{

		IntArrayReader reader;
		public MyIntArrayToStringReader(IntArrayReader reader) {
			this.reader=reader;
		}
		
		@Override
		public String readString() {
			StringBuilder sb=new StringBuilder();
			int[] array=reader.readIntArray();
			for(int i : array)
				sb.append(i+" ");
			return sb.toString();
		}
		
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
