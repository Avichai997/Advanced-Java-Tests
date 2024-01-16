package test;

import java.util.HashMap;
import java.util.LinkedList;

public class Q1 {
	
	public static class MyStack<T>{
		LinkedList<T> list; // you must use this list to store the items of the stack
		HashMap<T,Integer> hash;
		
		public MyStack() {
			list=new LinkedList<>();
			hash=new HashMap<>();
		}
		
		public void push(T t){
			list.add(0, t);
			Integer i=hash.get(t);
			if(i!=null)
				hash.put(t,(i+1));
			else
				hash.put(t,1);
		}
		
		public T pop(){
			T t=list.removeFirst();
			Integer i=hash.get(t);
			if(i==1)
				hash.remove(t);
			else
				hash.put(t, (i-1));
			return t;
		}
		
		public T peek(){			
			return list.peek();
		}
		
		public boolean contains(T t){
			return hash.containsKey(t);
			//return list.contains(t); // note that this is O(n)
		}
		
		public int size(){
			return list.size();
		}
	}
	
	public static void testAPI(){
		MyStack<Integer> stack=new MyStack<>();
		stack.push(15);
		stack.push(14);
		stack.push(13);
		stack.push(12);
		System.out.println(stack.peek()); // 12
		Integer i = stack.pop();
		System.out.println(i); // 12
		System.out.println(stack.contains(12)); // false
		System.out.println(stack.contains(13)); // true
		stack.push(13); // 13 appears twice now
		stack.push(13); // 13 appears 3 times now
		stack.pop();
		System.out.println(stack.contains(13)); // true
		stack.pop();
		System.out.println(stack.contains(13)); // true
		stack.pop();
		System.out.println(stack.contains(13)); // false
		
	}

}
