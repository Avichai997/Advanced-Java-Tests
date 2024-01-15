package test;


public class Controller {

	public interface Command{
		int getID();
		void execute();
	}
	
	
	PriorityQueue<__________> queue;
	
	public Controller() {}
	
	public void insertCommand(Command c){}
	
	public void executeOne(){
		if(!queue.isEmpty())
			queue.poll().execute();
	}
	
	public void executeAll(){
		while(!queue.isEmpty())
			queue.poll().execute();
	}
}

