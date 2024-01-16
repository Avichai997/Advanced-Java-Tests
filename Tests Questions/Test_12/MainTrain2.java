package test;

public class MainTrain2 {

	public static void main(String[] args) {
		String input="n1->n2;n1->n3;goal<->n4;n4<-n1";
		Graph g=new Graph(input);
		
		if(Node.count!=5)
			System.out.println("wrong number of nodes (-15)");
		
		if(!g.hasEdge("n1", "n2"))
			System.out.println("an edge is missing (-5)");
		
		if(!g.getNode("n1").outEdges.contains(g.getNode("n3")))
			System.out.println("an edge is missing (-5)");
		
		if(!g.getNode("goal").outEdges.contains(g.getNode("n4")))
			System.out.println("an edge is missing (-5)");
		
		if(!g.hasEdge("n4","goal"))
			System.out.println("an edge is missing (-5)");
		
		if(!g.hasEdge("n1","n4"))
			System.out.println("an edge is missing (-5)");
		
		if(g.hasEdge("n5","n1"))
			System.out.println("redundant edge (-5)");
		
		if(g.hashNode("n5"))
			System.out.println("redundant node (-5)");
		
		
		System.out.println("done");
	}

}
