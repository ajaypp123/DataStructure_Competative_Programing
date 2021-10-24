
/*
Problem:
    Graph Coloring Problem

    Graph coloring (also called vertex coloring) is a way of coloring a graph’s vertices such that no two adjacent vertices share the same color.
    - No two adjacent will have same color.

Terminology:

    Chromatic Number:
        The smallest number of color for graph coloring.
    K-colorable:
        If graph can be color with k color called k colorable graph.

Example:
    new Edge(0, 1), new Edge(0, 4),
    new Edge(0, 5), new Edge(4, 5),
    new Edge(1, 4), new Edge(1, 3),
    new Edge(2, 3), new Edge(2, 4)

Output: 3
    The color assigned to vertex 0 is BLUE
    The color assigned to vertex 1 is GREEN
    The color assigned to vertex 2 is BLUE
    The color assigned to vertex 3 is RED
    The color assigned to vertex 4 is RED
    The color assigned to vertex 5 is GREEN

=========================================================================
Algorithm:
    - It can be solved by greedy algorithm, to select first available color for each adjacent node.
    - With recursion and condition we can check possible color.


    // color not same to adj vertex color
    // for directed graph convert to undirected graph
    colorGraph(int[][] graph, int V, String[] color, String[] result)
        // assign color to each one
        for i=0 to V
            // Set adjColor
            // First unassigned color

*/

import java.util.*;

public class GraphColoring {

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

    private static HashSet<String> getAdjColor(int source,
        HashMap<Integer, List<Integer>> map, String[] result) {
        // get adj color
        HashSet<String> set = new HashSet<>();
        for(int i: map.get(source)) {
            set.add(result[i]);
        }
        return set;
    }

    private static String getNonAdjColor(HashSet<String> adjColor, String[] color) {
        String newColor = "";
        for(String c: color) {
            if(!adjColor.contains(c)) {
                newColor = c;
                break;
            }
        }
        return newColor;
    }

    private static String[] colorGraph(int[][] graph, int V, String[] color) {
        String[] result = new String[V];
        Arrays.fill(result, "");

        // get map of graph
        HashMap<Integer, List<Integer>> map = getMap(graph);

        // assign first color to 0
        result[0] = color[0];

        // color each vertex
        for(int i=1; i<V; i++) {
            // get adj color of i
            HashSet<String> adjColor = getAdjColor(i, map, result);

            // assign first not adj color
            result[i] = getNonAdjColor(adjColor, color);
        }
        return result;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 1}, {0, 4},
                {0, 5}, {4, 5},
                {1, 4}, {1, 3},
                {2, 3}, {2, 4}
            };
        String[] color = {
            "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",
            "BLACK", "BROWN", "WHITE", "PURPLE", "VIOLET"
            };

        String[] result = colorGraph(graph, 6, color);

        HashSet<String> total = new HashSet<>();
        for(int i=0; i<result.length; i++) {
            total.add(result[i]);
            System.out.printf("Color for %d is %s\n", i, result[i]);
        }
        System.out.printf("Chromatic number for graph is %d.\n", total.size());
    }
}