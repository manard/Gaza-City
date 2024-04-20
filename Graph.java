import java.util.LinkedList;

public class Graph {
	private int numberOfVertix;
	private int numberOfEdge;
	private Vertix vertixArray[];
	private Edge edgeArray[];
	private LinkedList<Edge> Adj[];// array of linkedList,each index linkedlist
	private static int i = 0;
	private static int j = 0;

	public Graph(int numberOfVertix, int numberOfEdge) {
		super();
		this.numberOfVertix = numberOfVertix;
		this.numberOfEdge = numberOfEdge;
		vertixArray = new Vertix[numberOfVertix];
		edgeArray = new Edge[numberOfEdge];
		Adj = new LinkedList[numberOfVertix];
	}

	public void addVertix(Vertix vertix) {
		vertixArray[i] = vertix;
		Adj[i++] = new LinkedList();
		// creates a new Edge object with vertix as both the source and target vertices
		// and a weight
	}

	// adds an edge to a graph represented by an adjacency list.
	public void addEdge(Edge edge, int source, int target) {
		edgeArray[j++] = edge;
		Adj[source].addLast(edge);

	}

	public int getNumberOfVertix() {
		return numberOfVertix;
	}

	public void setNumberOfVertix(int numberOfVertix) {
		this.numberOfVertix = numberOfVertix;
	}

	public int getNumberOfEdge() {
		return numberOfEdge;
	}

	public void setNumberOfEdge(int numberOfEdge) {
		this.numberOfEdge = numberOfEdge;
	}

	public Vertix[] getVertixArray() {
		return vertixArray;
	}

	public void setVertixArray(Vertix[] vertixArray) {
		this.vertixArray = vertixArray;
	}

	public Edge[] getEdgeArray() {
		return edgeArray;
	}

	public void setEdgeArray(Edge[] edgeArray) {
		this.edgeArray = edgeArray;
	}

	public LinkedList<Edge>[] getAdj() {
		return Adj;
	}

	public void setAdj(LinkedList<Edge>[] adj) {
		Adj = adj;
	}

}
