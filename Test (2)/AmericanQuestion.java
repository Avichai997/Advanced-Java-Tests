package test;


public class AmericanQuestion {
	// SOLID & GRASP Principles
	String[] principles={	"Single responsibility", 	//0
							"Open close",				//1
							"Liskov substitution",		//2
							"Interface segregation",	//3
							"Dependency inversion",		//4							
							"Creator", 					//5
							"Controller",				//6
							"Pure Fabrication",			//7
							"Information Expert",		//8
							"High Cohesion",			//9
							"Low Coupling",				//10
							"Indirection",				//11
							"Polymorphism",				//12
							"Protected Variations"		//13
			};
	
	/***
	 * each question depicts a code in the comments which defies a principle
	 * return the string which **best** depicts this principle 
	 */
	public String q1(){
		// void execute(Runnable r){
		//		...
		//		((MyRunnable)r).setParams(x,y,z);
		//		r.run();
		// }
		return "";
	}
	
	public String q2(){
		// MathematicalObject m=new MathematicalObject();
		// double x = m.cos(2*m.Pi()) + m.sin(m.e());
		return "";
	}
	
	public String q3(){
		// Maze m=new Maze();
		// m.generate(10,10);
		// m.setCharacter(0,0);
		// m.print();
		return "";
	}
	
	public String q4(){
		// User u=new User();
		// Date d=new Date();
		// Event e=new Event();
		// Calendar c=new calendar();
		// u.insertNewEvent(e,c,d);
		return ""; // I'll accept also [0]
	}
	
}
