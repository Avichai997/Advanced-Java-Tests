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
			Item item=new Item();
			item.data=data;
			item.next=head.next;
			head.next=item;
			size++;			
		}
		
		public int size(){ return size;}
		
		public class RoundListIterator implements Iterator<T>{
			Item p;			
			public RoundListIterator() {
				p=head.next;
			}

			@Override
			public boolean hasNext() {				
				return p!=head;
			}

			@Override
			public T next() {
				T data = p.data;
				p=p.next;
				return data;
			}
			
			public T nextR(){
				T data = p.data;
				p=p.next;
				if(p==head && size>1){
					p=p.next;
				}
				return data;				
			}
			
		}
		
		@Override
		public Iterator<T> iterator() {
			return new RoundListIterator();
		}
		
		public RoundListIterator rIterator() {
			return new RoundListIterator();
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
		// notice: size+2, nextR
		letters.forEach((s)->System.out.print(s+","));// a,b,c,d,
		System.out.println();
		
		RoundList<String>.RoundListIterator it2=letters.rIterator();
		for(int i=0;i<letters.size()+2;i++)
			System.out.print(it2.nextR()+",");
		// a,b,c,d,a,b,
		System.out.println();
	}
}
