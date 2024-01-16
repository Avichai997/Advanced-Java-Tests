package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import test.Q2.ConsistentHasher.Server;


public class Q2 {
	
	public static class ConsistentHasher<T> {
		
		public interface Server<V>{
			String getName();
			V getValue(String key);
		}
		
		public List<Server<T>> servers;
		
		public ConsistentHasher() {servers=new LinkedList<>();}
		
		public int hash(Server<T> s){
			return s.getName().hashCode()%360;
		}
		
		public void sortServers(){
			Collections.sort(servers,new Comparator<Server<T>>() {
				@Override
				public int compare(Server<T> o1, Server<T> o2) {					
					return hash(o1)-hash(o2);
				}
			});
		}
		
		public void addServer(Server<T> server){
			servers.add(server);
			sortServers();
		}
		
		public void removeServer(Server<T> server){
			servers.remove(server);
			sortServers();
		}
			
		
		public T getValue(String key){			
			int index=key.hashCode()%360;
			Server<T> chosen;
			Iterator<Server<T>> it=servers.iterator();
			do{
				chosen=it.next();
			}while(index>hash(chosen) && it.hasNext());
			
			return chosen.getValue(key);
		}
		
		
	} // end of consistent hasher
	
	// do not change anything here!
	public static class TestServer implements Server<Integer>{

		private String name;
		private HashMap<String,Integer> map;

		public TestServer(String name) {
			this.name=name;
			map=new HashMap<>();
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public Integer getValue(String key) {
			return map.get(key);
		}
		
		public void putVal(String key, Integer val){
			map.put(key, val);
		}
	}
	
	public static void mainAPI() {
		TestServer t1=new TestServer("AA");
		TestServer t2=new TestServer("BB");
		TestServer t3=new TestServer("CC");
	
		t1.putVal("aa",1);
		t1.putVal("bb",2);
		t1.putVal("cc",3);
		
		t2.putVal("aa",11);
		t2.putVal("bb",22);
		t2.putVal("cc",33);

		t3.putVal("aa",111);
		t3.putVal("bb",222);
		t3.putVal("cc",333);
		
		ConsistentHasher<Integer> ch=new ConsistentHasher<>();
		ch.addServer(t1);
		ch.addServer(t2);
		ch.addServer(t3);
		
		System.out.println("t1 hash: "+ch.hash(t1)); // 280
		System.out.println("t2 hash: "+ch.hash(t2)); // 312
		System.out.println("t3 hash: "+ch.hash(t3)); // 314
		
		System.out.println(ch.getValue("aa")); // 1
		System.out.println(ch.getValue("bb")); // 2
		System.out.println(ch.getValue("cc")); // 33
		
		ch.removeServer(t2);
		
		System.out.println(ch.getValue("aa")); // 1
		System.out.println(ch.getValue("bb")); // 2
		System.out.println(ch.getValue("cc")); // 333
		
		ch.addServer(t2);
		ch.removeServer(t1);
		
		System.out.println(ch.getValue("aa")); // 11
		System.out.println(ch.getValue("bb")); // 22
		System.out.println(ch.getValue("cc")); // 33
		
	}

}
