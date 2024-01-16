package test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Controller {

	public interface Command{
		int getID();
		void execute();
	}
	
	private  class ACommand{		
		long executionTime;
		Command c;
		public ACommand(Command c){
			this.c=c;
			executionTime=0;
		}
		public void execute(){
			long time=System.currentTimeMillis();
			c.execute();
			executionTime=System.currentTimeMillis()-time;
		}
	}
	
	PriorityQueue<ACommand> queue;
	HashMap<Integer,ACommand> map;
	
	public Controller() {
		queue=new PriorityQueue<ACommand>(new Comparator<ACommand>() {
			@Override
			public int compare(ACommand o1, ACommand o2) {
				return (int)(o1.executionTime-o2.executionTime);
			}
		});
		map=new HashMap<>();
	}
	
	public void insertCommand(Command c){
		ACommand ac=map.get(c.getID());
		if(ac==null){
			ac=new ACommand(c);
			map.put(c.getID(), ac);
		}
		queue.add(ac);
	}
	
	public void executeOne(){
		if(!queue.isEmpty())
			queue.poll().execute();
	}
	
	public void executeAll(){
		while(!queue.isEmpty())
			queue.poll().execute();
	}
}
