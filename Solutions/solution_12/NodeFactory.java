package test;

import java.util.HashMap;

public class NodeFactory {

	HashMap<String,Node> map;
	
	public NodeFactory() {
		map=new HashMap<>();
	}
	
	public Node get(String id){
		if(map.containsKey(id))
			return map.get(id);
		
		Node n=new Node(id);
		map.put(id, n);
		return n;
	}

	public boolean hasNode(String id){
		return map.containsKey(id);
	}
}
