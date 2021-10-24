
/*
Spanning Tree:
    - It is part of graph having V-1 edges and cover all points.
    - It is sub part of graph, there can be multiple combination possible.

Minimum Cost Spanning Tree:
    - Spanning Tree whose edge cost is minimum called minimum cost spanning tree.

Algorithm to find Minimum Cost Spanning Tree in Undirected graph:
    - Kruskal
    - Prims

==================================================================================

Prims:
    - Here, select first sort edge from any source point.
    - Then keep select minimum adjecent edge, till selected count  became V-1.
        - Skip edge if all point are already selected and not creating cycle.

Kruskal:
    - Algorithm to find minimum cost spanning tree.
    - Here, we select edges having minimum cost, one by one till all node are visited.

    1. Create visited array and all all edges to priority queue.
    2. count = 0
    3. while queue empty or count < V-1
        if(any one point not visited and no cycle by considering edge)
            cost+= edge.cost
            count++

    // AS it is for undirected graph we can use Uninon Find for cycle detection

==========================================================================================

Complexity:
Time: O(Edges * log(n))     // for each edge -> union find

*/

import java.util.*;

class Edge implements Comparable<Edge>{
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        if(this.weight < e.weight) {
            return -1;
        } else if(this.weight > e.weight){
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + src + ", " + dest + ", " + weight + ")";
    }
}

public class KruskalSpanningTree {

    private static void makeSet(int[] parent, int[] rank) {
        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);
    }

    private static void Union(int a, int b, int[] parent, int[] rank) {
        int x = Find(a, parent);
        int y = Find(b, parent);

        // If x==y, they already in same set
        if(x==y){return;}

        // make higher rank as parent and lower rank as child to keep low depth
        if(rank[x] > rank[y]) {
            parent[y] = x;
        } else if(rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            // both have same rank so make any one as parent and increase rank
            parent[x] = y;
            rank[y] += 1;
        }
    }

    private static int Find(int x, int[] parent) {
        if(x == parent[x]) {
            return x;
        }
        return Find(parent[x], parent);
    }


    private static List<Edge> kruskalAlgo(List<Edge> edges, int N) {

        // Add all edge in priority queue
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(Edge e: edges) {
            pq.add(e);
        }

        // count edge selected
        int count = 0;
        int cost = 0;

        // makeset to detect cycle
        int[] parent = new int[N];
        int[] rank = new int[N];
        makeSet(parent, rank);

        // Add seleted edges in list
        List<Edge> list = new ArrayList<>();
        while(pq.size()!=0 || count!=N-1) {
            Edge e = pq.remove();
            int x = Find(e.src, parent);
            int y = Find(e.dest, parent);

            if(x!=y) {
                Union(x, y, parent, rank);
                list.add(e);
                cost += e.weight;
                count++;
            }
        }
        System.out.println("Minimum Cost Spanning Tree: " + cost);

        return list;
    }

    public static void main(String[] args) {
        // `(u, v, w)` triplet represent undirected edge from
        // vertex `u` to vertex `v` having weight `w`
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 7), new Edge(1, 2, 8),
                new Edge(0, 3, 5), new Edge(1, 3, 9),
                new Edge(1, 4, 7), new Edge(2, 4, 5),
                new Edge(3, 4, 15), new Edge(3, 5, 6),
                new Edge(4, 5, 8), new Edge(4, 6, 9),
                new Edge(5, 6, 11)
        );

        // total number of nodes in the graph
        final int N = 7;

        // construct graph
        List<Edge> e = kruskalAlgo(edges, N);
        System.out.println(e);
    }
}
