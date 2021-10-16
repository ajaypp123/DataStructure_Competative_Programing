

/*

Problem: Single source shortest path algorithm.

Given a source vertex s from a set of vertices V in a weighted graph where all its edge weights w(u, v) are non-negative, find the shortest path weights d(s, v) from source s  for all vertices v present in the graph.

x-->y
x\y 0   1   2   3   4
0   0   10  0   0   3
1   0   0   2   0   4
2   0   0   0   9   0
3   0   0   7   0   0
4   0   1   8   2   0

Edges:
    new Edge(0, 1, 10), new Edge(0, 4, 3),
    new Edge(1, 2, 2), new Edge(1, 4, 4),
    new Edge(2, 3, 9), new Edge(3, 2, 7),
    new Edge(4, 1, 1), new Edge(4, 2, 8),
    new Edge(4, 3, 2)

Shortest Path:
    Path (0 to 4): Min Cost: 3, Route: 0->4
    Path (0 to 1): Min Cost: 4, Route: 0->4->1
    Path (0 to 3): Min Cost: 5, Route: 0->4->3
    Path (0 to 2): Min Cost: 6, Route: 0->4->1->2
=========================================================

Algorithm:
    1. Dijkstra
    2. BellmanFord (Work with negative path also but slower)

=============================================
Dijkstra
    - Similar to BFS but instead selecting any adjacent edge select minimum adjacent edge.

    1. Add (0,0,0) ie (src, dest, cost) in priority queue and mark 0 visited
    2. While pq empty
        e = pop
        vis[src] = true
        cost += e.cost;
        for(adj: e) {if(dest not visited) pq.add(ajd)}

    - select adj minimum edge till all visited.

Limitation:
    - Not work with negative edges. as we visit and return then edges will get subtracted again.
    - eg: {0,1,10} {0,2,5} {1,2,-8}
    // Here, source i.e. 0, we add adj i.e. 0-->1(cost:10) and 0-->2(cost:5)
                            After that we peak and fix, 0->2(cost:5) and algo end for 0->2
                            but due to negative 0->1->2(cost:2) is missed.
=====================================================================================

Complexity:
 complexity is O (V + E*log(V))
*/

import java.util.*;

class Path implements Comparable<Path>{
    public String path;
    public int cost;
    public int source;
    public int dest;

    Path(String path, int cost) {
        this.path = path;
        this.cost = cost;
        source = path.charAt(0) - '0';
        dest = path.charAt(path.length()-1) - '0';
    }

    public int compareTo(Path e2) {
        if(this.cost > e2.cost) {
            return 1;
        } else if(this.cost < e2.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Dijkstra {

    private static void shortestPath(int[][] g, int src) {
        // create pq
        PriorityQueue<Path> pq = new PriorityQueue<>();
        pq.add(new Path(String.valueOf(src), 0));

        // Visited array and src mark visited
        boolean[] visited = new boolean[g.length];
        visited[pq.peek().source] = true;

        while(pq.size() != 0) {
            // select minimum edge
            Path p = pq.remove();

            // for x-->y if y not visited then found shortest path from src to dest
            if(!visited[p.dest]) {
                // Not visited dest, visit and print path
                // Path (0 —> 1): Minimum cost = 4, Route = [0, 4, 1]
                System.out.println(String.format(
                    "Path (%d to %d): Min Cost: %d, Route: %s",
                    p.source, p. dest, p.cost, p.path));
                // Mark dest visited
                visited[p.dest] = true;
            }

            // Add adj of destination to find next path, x-->y-->next
            for(int i=0; i<g[p.dest].length; i++) {

                // If edge present y-->i : g[p.dest][i] !=0
                // If i not already visited: visited[i]==false
                // No self edge: p.dest-->p.dest: i!=p.dest
                if(!visited[i] && p.dest!=i && g[p.dest][i]!=0) {
                    // Now add new distance to queue
                    // previous_path + next
                    String path = p.path + "->" + String.valueOf(i);
                    // new cost = path_cost + cost(p.dest to i)
                    int cost = p.cost + g[p.dest][i];

                    pq.add(new Path(path, cost));
                }
            }
        }
    }

	public static void main(String[] args) {
        /*
            Shortest Path:
                Path (0 —> 1): Minimum cost = 4, Route = [0, 4, 1]
                Path (0 —> 2): Minimum cost = 6, Route = [0, 4, 1, 2]
                Path (0 —> 3): Minimum cost = 5, Route = [0, 4, 3]
                Path (0 —> 4): Minimum cost = 3, Route = [0, 4]
        */
		int graph[][] = new int[][] {
                    {0, 10, 0, 0, 3},
                    {0, 0, 2, 0, 4},
                    {0, 0, 0, 9, 0},
                    {0, 0, 7, 0, 0},
                    {0, 1, 8, 2, 0}};

        shortestPath(graph, 0);
	}
}
