package test;

import java.util.Iterator;

public class Q3 {

	public static class RoundList<T> implements Iterable<T>{

		class Item {
			T data;
			Item next;
		}
		
		Item head; // just used as a borderline, contains no data
		int size;
		
		public RoundList() {
			head=new Item();
			head.next=head;
		}
		
		public void push(T data){ // pushes the data next to head
			___________________________
			___________________________
			___________________________
			___________________________
			___________________________
			___________________________
		}
		
		public int size(){ return size;}
		
		public class RoundListIterator implements Iterator<T>{
			______________;			
			public RoundListIterator() {
				___________________;
			}

			@Override
			public boolean hasNext() {				
				______________________;
			}

			@Override
			public T next() {
				____________________
				____________________
				____________________
			}
			
			public T nextR(){ // same as next, but skips head
				____________________
				____________________
				____________________
				____________________
				____________________
				____________________
			}
			
		}
		
		@Override
		public Iterator<T> iterator() {
			return __________________________;
		}
		
		public RoundListIterator rIterator() {
			return __________________________;
		}
		
	}
	
	public static void mainAPI() {
		RoundList<String> letters=new RoundList<>();
		letters.push("d");
		letters.push("c");
		letters.push("b");
		letters.push("a");
		
		Iterator<String> it=letters.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+",");
		}// a,b,c,d,
		System.out.println();
		
		for(String s : letters){
			System.out.print(s+",");
		}// a,b,c,d,
		System.out.println();
		
		letters.forEach((s)->System.out.print(s+","));// a,b,c,d,
		System.out.println();
		
		RoundList<String>.RoundListIterator it2=letters.rIterator();
		// notice: size+2, nextR
		for(int i=0;i<letters.size()+2;i++)
			System.out.print(it2.nextR()+",");
		// a,b,c,d,a,b,
		System.out.println();
	}
}
