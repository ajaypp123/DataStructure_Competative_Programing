
/*
Problem:
    bipartite graph

    Given a graph, check if it is bipartite or not. A bipartite graph (or bigraph) is a graph whose vertices can be divided into two disjoint sets U and V such that every edge connects a vertex in U to one in V.

Terminology:

    bipartite graph: graph can be colored by only two color.

Example:
    new Edge(0, 1), new Edge(0, 4),
    new Edge(0, 5), new Edge(4, 5),
    new Edge(1, 4), new Edge(1, 3),
    new Edge(2, 3), new Edge(2, 4)

Output: false // as total color is 3

=========================================================================
Algorithm:
    - It can be solved by greedy algorithm, to select first available color for each adjacent node.
    - With recursion and condition we can check possible color.


    // color not same to adj vertex color
    // for directed graph convert to undirected graph
    colorGraph(int[][] graph, int V)
        colorGraph(map, 0, V, res)

    int colorGraph(HM map, int src, int V, int[] res)
        if V==0 return 0
        if res[src] !=-1 return res[src]

        // assign color to current node
        res[src] = get_unassign_color(map)
        max = res[src]

        // call again for adj color
        for adj: map.get(src):
            max1 = colorGraph(map, adj, V-1, res)
            max = Max(max,max1)

        return max
*/

import java.util.*;

public class CheckBipartite {

    private static HashMap<Integer, List<Integer>> getMap(int[][] graph) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: graph) {
            int x = edge[0];
            int y = edge[1];

            // x--y
            if(map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(y);
                map.put(x, li);
            }

            // y--x
            if(map.containsKey(y)) {
                map.get(y).add(x);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(x);
                map.put(y, li);
            }
        }
        return map;
    }

    private static HashSet<Integer> getAdjColor(int source,
        HashMap<Integer, List<Integer>> map, int[] result) {
        // get adj color
        HashSet<Integer> set = new HashSet<>();
        for(int i: map.get(source)) {
            set.add(result[i]);
        }
        return set;
    }

    private static int getNonAdjColor(HashSet<Integer> adjColor) {
        int color = 1;
        int assignColor = -1;
        while(assignColor==-1) {
            if(!adjColor.contains(color)) {
                assignColor = color;
                break;
            }
            color++;
        }
        return assignColor;
    }

    private static int colorGraph(HashMap<Integer, List<Integer>>  map,
        int src, int V, int[] res) {
        if(V==0) {
            return 0;
        }

        if(res[src]!=-1) {
            return res[src];
        }

        int max = 0;
        // assign first not adj color
        HashSet<Integer> adjColor = getAdjColor(src, map, res);
        // assign color to self node
        res[src] = getNonAdjColor(adjColor);
        max = res[src];

        // assign color to adj
        for(int i: map.get(src)) {
            if(res[i]==-1) {
                int m = colorGraph(map, i, V, res);
                max = Math.max(m, max);
            }
        }

        return max;
    }

    private static boolean checkBipartite(int[][] graph, int V) {
        // get map of graph
        HashMap<Integer, List<Integer>> map = getMap(graph);
        int[] res = new int[V];
        Arrays.fill(res, -1);
        int chromaticNum = colorGraph(map, 0, V, res);
        System.out.println(chromaticNum);
        return chromaticNum == 2;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 1}, {0, 4},
                {0, 5}, {4, 5},
                {1, 4}, {1, 3},
                {2, 3}, {2, 4}
            };
        System.out.println("Check Bipartite for graph is " +
                            checkBipartite(graph, 6));

        int[][] graph1 = new int[][]{
                            {0, 1}, {1, 2}, {1, 7},
                            {2, 3}, {3, 5}, {4, 6},
                            {4, 8}, {7, 8}
                        };
        System.out.println("Check Bipartite for graph is " +
                            checkBipartite(graph1, 9));
    }
}