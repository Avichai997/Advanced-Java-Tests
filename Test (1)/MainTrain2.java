package test;

import test.Controller.Command;

public class MainTrain2 {
	
	static String res="";
	
	static class MyCommand implements Command{
		private int id;
		private long time;

		public MyCommand(int id,long time) {
			this.id=id;
			this.time=time;
		}
		@Override
		public int getID() {
			return id;
		}

		@Override
		public void execute() {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {}
			res+=id+"";
		}		
	}
	
	public static void q2(){
		
		Controller controller=new Controller();
		controller.insertCommand(new MyCommand(1, 30));
		controller.executeOne();
		if(!res.equals("1"))
			System.out.println("failed to insert and execute command for question 2  (-5)"); // 5
		controller.insertCommand(new MyCommand(2, 20));
		controller.insertCommand(new MyCommand(3, 10));
		controller.executeAll();
		if(res.length()!=3)
			System.out.println("failed to insert and execute several commands for question 2  (-5)"); // 5
		res="";
		controller.insertCommand(new MyCommand(1, 30));
		controller.insertCommand(new MyCommand(2, 20));
		controller.insertCommand(new MyCommand(3, 10));
		controller.executeAll(); // 3,2,1
		if(!res.equals("321"))
			System.out.println("failed logic for question 2  (-15)"); // 15
	}
	
	
	public static void main(String[] args) {
		q2();
		System.out.println("done");
	}

}
