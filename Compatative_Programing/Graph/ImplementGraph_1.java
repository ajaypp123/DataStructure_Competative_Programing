
/*
Implement graph using given metrix

		// Only directed graph
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

		// Can be directed or undirected graph
		int points[][] = new points[][]{{0,1}, {0,3}, {3,0}, {1,2}, {2,3}}

*/

// Importing utility classes
import java.util.*;

// G has edge and vertex
class NewGraph {
	/*
		Use either ArrayList<NewEdge> edges; or ArrayList<ArrayList<Integer>> linkedEdges;
	*/

	// Store all edges
	ArrayList<NewEdge> edges;

	// Represet in linked edges to get adjecent edges
	/*
	index		element
	0		-> 	1, 2
	1		->  3
	2		-> 	3
	*/
	public HashMap<Integer, ArrayList<Integer>> linkedMap;

	// Store all vertex
	HashSet<Integer> vertex;
	public int cost;

	NewGraph() {
		this.edges = new ArrayList<>();
		this.vertex = new HashSet<>();
		linkedMap = new HashMap<Integer, ArrayList<Integer>>();
		this.cost=0;
	}

	void addEdge(int src, int dest, int cost) {
		// Edges
		edges.add(new NewEdge(src, dest, cost));

		// map edges
		ArrayList<Integer> list;
		if(linkedMap.containsKey(src)) {
			list = linkedMap.get(src);
			list.add(dest);
			//linkedMap.put(src, list);
		} else {
			list = new ArrayList<>();
			list.add(dest);
			linkedMap.put(src, list);
		}

		vertex.add(src);
		vertex.add(dest);
		this.cost+=cost;
	}
}

class NewEdge {
	public int src;
	public int dest;
	public int cost;

	NewEdge(int src, int dest, int cost) {
		this.src = src;
		this.dest = dest;
		this.cost = cost;
	}
}

public class ImplementGraph_1 {

	private static void pointsToGraph(int[][] points) {
		NewGraph g = new NewGraph();

		for(int i=0; i<points.length; i++) {
			g.addEdge(points[i][0], points[i][1], 1);
		}
		printGraph(g);
	}

	private static void metrixToGraph(int[][] graph) {
		NewGraph g = new NewGraph();

		for(int i=0; i<graph.length; i++) {
			for(int j=0; j<graph[i].length; j++) {
				if(graph[i][j] != 0) {
					g.addEdge(i, j, graph[i][j]);
				}
			}
		}

		printGraph(g);
	}

	private static void printGraph(NewGraph g) {
		for(int i: g.linkedMap.keySet()) {
			System.out.println(i + " " + g.linkedMap.get(i).toString());
		}
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

		int points[][] = new int[][]{{0,1}, {0,3}, {3,0}, {1,2}, {2,3}};

		metrixToGraph(graph);
		System.out.println();
		pointsToGraph(points);
	}
}
