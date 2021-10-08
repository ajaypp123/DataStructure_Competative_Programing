
/**
 *      //0-1-3 0-2
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        // 4-5-6-4
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
 output:2

 */

import java.util.*;


class Edge {

    public int x;
    public int y;

    Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Graph{
    public ArrayList<Edge> eg;
    public int count;

    public Graph(int V){
        count = V;
        eg = new ArrayList<>();
    }

    public void addEdge(int source, int destination){
        //add forward edge
        eg.add(new Edge(source, destination));
    }
}


public class DisconnectedGraph {

    private static int getDis(Graph g) {
        int[] P = new int[g.count];
        // set p
        for(int i=0; i<P.length; i++) {
            P[i] = i;
        }

        for(Edge e: g.eg) {
            int p1 = find(P, e.x);
            int p2 = find(P, e.y);

            if(p1 != p2) {
                Set(P, Math.max(e.x, e.y), Math.min(e.x, e.y));
            }
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<P.length; i++) {
            if(!hs.contains(P[i])) {
                hs.add(P[i]);
            }
        }

        return hs.size();
    }

    private static int find(int[] P, int ele) {
        if(ele == P[ele]) {
            return ele;
        } else {
            return find(P, P[ele]);
        }
    }

    private static void Set(int[] P, int c, int p) {
        int gp = find(P, p);
        P[c] = gp;
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        //0-1-3 0-2
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);

        // 4-5-6-4
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);

        System.out.println(getDis(g));
    }
}