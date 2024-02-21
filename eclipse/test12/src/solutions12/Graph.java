package solutions12;

public class Graph {

	NodeFactory nf;

	public Graph(String input) {
		nf = new NodeFactory();
		String[] edges = input.split(";");
		for (String edge : edges) {
			// a->b
			// a<-b
			// a<->b
			String nodes[] = edge.split("-");
			if (nodes[0].endsWith("<"))
				nodes[0] = nodes[0].substring(0, nodes[0].length() - 1);
			if (nodes[1].startsWith(">"))
				nodes[1] = nodes[1].substring(1);

			Node a = nf.get(nodes[0]);
			Node b = nf.get(nodes[1]);

			if (edge.contains(">"))
				a.addEdgeTo(b);

			if (edge.contains("<"))
				b.addEdgeTo(a);
		}
	}

	public boolean hashNode(String id) {
		return nf.hasNode(id);
	}

	public boolean hasEdge(String from, String to) {
		if (nf.hasNode(from) && nf.hasNode(to))
			return nf.get(from).getOutEdges().contains(nf.get(to));
		return false;
	}

	public Node getNode(String id) {
		if (nf.hasNode(id))
			return nf.get(id);
		return null;
	}

}
