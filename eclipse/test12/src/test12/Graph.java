package test12;

public class Graph {

	NodeFactory nf;

	public Node[] getNodes(String s, String regex) {
		String[] nodes = s.split(regex);
		// n1->n3
		Node left;
		Node right;

		if (hasNode(nodes[0]))
			left = nf.get(nodes[0]);
		else {
			left = new Node(nodes[0]);
			nf.nodes.put(left.id, left);
		}
		if (hasNode(nodes[1]))
			right = nf.get(nodes[1]);
		else {
			right = new Node(nodes[1]);
			nf.nodes.put(right.id, right);
		}

		return new Node[] { left, right };
	}

	public Graph(String input) {
		nf = new NodeFactory();
		// " n1->n2;n1->n3;goal<->n4;n4<-n1 ".

		String[] temp = input.split(";");
		// n1->n2
		// n1->n3
		// goal<->n4
		// n4<-n1

		for (String pair : temp) {
			if (pair.contains("<->")) {
				// goal<->n4
				Node[] nodes = getNodes(pair, "<->");
				if (!hasEdge(nodes[0].id, nodes[1].id))
					nodes[0].addEdgeTo(nodes[1]);
				if (!hasEdge(nodes[1].id, nodes[0].id))
					nodes[1].addEdgeTo(nodes[0]);
			} else if (pair.contains("->")) {
				// n1->n3
				Node[] nodes = getNodes(pair, "->");
				if (!hasEdge(nodes[0].id, nodes[1].id))
					nodes[0].addEdgeTo(nodes[1]);
			} else if (pair.contains("<-")) {
				// n4<-n1
				Node[] nodes = getNodes(pair, "<-");
				if (!hasEdge(nodes[1].id, nodes[0].id))
					nodes[1].addEdgeTo(nodes[0]);
			}
		}
	}

	public boolean hasNode(String id) {
		return nf.hasNode(id);
	}

	public boolean hasEdge(String from, String to) {
		if (!hasNode(from) || !hasNode(to))
			return false;
		return nf.get(from).outEdges.contains(nf.get(to));

//		// long way:
//		Node fromNode = nf.get(from);
//		Node toNode = nf.get(to);
//		
//		for(Node n : fromNode.outEdges) 
//			if(n.equals(toNode))
//				return true;
//		
//		return false;
	}

	public Node getNode(String id) {
		if (hasNode(id))
			return nf.get(id);
		return null;
	}

}
