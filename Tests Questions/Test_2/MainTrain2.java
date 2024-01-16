package test;

public class MainTrain2 {

	public static void main(String[] args) {
		Property<Integer> i=new Property<Integer>();
		Property<Integer> j=new Property<Integer>();
		Property<Integer> k=new Property<Integer>();
		Property<Integer> l=new Property<Integer>();
		Property<Integer> m=new Property<Integer>();
		Property<Integer> n=new Property<Integer>();
		Property<Integer> o=new Property<Integer>();
		i.setValue(0);
		j.setValue(0);
		k.setValue(0);
		l.setValue(0);
		m.setValue(0);
		n.setValue(0);
		o.setValue(0);
		
		i.bind(j);
		i.bind(k);
		i.bind(l);
		j.bind(m);
		m.bind(n);
		
		i.setValue(5);
		if(j.getValue()!=5)
			System.out.println("single bind does not work (-10)"); // 10
		if(k.getValue()!=5)
			System.out.println("double bind does not work (-5)"); // 5
		if(l.getValue()!=5)
			System.out.println("multiple bind does not work (-5)"); // 5
		if(m.getValue()!=5)
			System.out.println("single transitive bind does not work (-10)"); // 10
		if(n.getValue()!=5)
			System.out.println("double transitive bind does not work (-5)"); // 5
		
		// test mistakes of static implementations 
		if(o.getValue()==5)
			System.out.println("properties which are not bonded are changed (-10)"); // 10 
		
		System.out.println("done");
	}

}
