package test;

import java.util.ArrayList;

public class Node {

	public static int count=0;
	
	ArrayList<Node> outEdges;
	String id;
	
	public Node(String id){
		this.id=id;
		outEdges=new ArrayList<>();
		count++;
	}
	
	public void addEdgeTo(Node to){
		outEdges.add(to);
	}
	
	public ArrayList<Node> getOutEdges(){
		return outEdges; 
	}
	
	public boolean equals(Node other){
		return id.equals(other.id);
	}
}
