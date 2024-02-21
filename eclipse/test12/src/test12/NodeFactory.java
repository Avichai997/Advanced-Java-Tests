package test12;

import java.util.HashMap;

public class NodeFactory {
	HashMap<String, Node> nodes;

	public NodeFactory() {
		nodes = new HashMap<>();
	}

	public Node get(String id) {
		if (nodes.containsKey(id))
			return nodes.get(id);

		Node newNode = new Node(id);
		nodes.put(id, newNode);
		return newNode;
	}
	
	public Boolean hasNode(String id) {
		return nodes.containsKey(id);
	}
}
