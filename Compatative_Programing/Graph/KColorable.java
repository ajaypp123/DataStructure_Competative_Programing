
/*
Problem:
Print all k–colorable configurations of a graph (Vertex coloring of a graph)

Given a graph, find if it is k–colorable or not and print all possible configurations of assignment of colors to its vertices.

k–colorable:
    - If graph can be colored by k color then it is k-colorable graph
    - mean k>= chromatic number.

Print all possible combination of graph.

Problem:
    graph = {0, 1}, {0, 4}, {0, 5}, {4, 5}, {1, 4}, {1, 3}, {2, 3}, {2, 4}
    COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
            "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};
    k = 3

    only k=3 color are possible so combination have only "BLUE", "GREEN", "RED"
    if k=4 then combination have "BLUE", "GREEN", "RED", "YELLOW"

Answer:
[BLUE, GREEN, BLUE, RED, RED, GREEN]
[BLUE, GREEN, GREEN, BLUE, RED, GREEN]
[BLUE, GREEN, GREEN, RED, RED, GREEN]
[BLUE, RED, BLUE, GREEN, GREEN, RED]
[BLUE, RED, RED, BLUE, GREEN, RED]
[BLUE, RED, RED, GREEN, GREEN, RED]
[GREEN, BLUE, BLUE, GREEN, RED, BLUE]
[GREEN, BLUE, BLUE, RED, RED, BLUE]
[GREEN, BLUE, GREEN, RED, RED, BLUE]
[GREEN, RED, GREEN, BLUE, BLUE, RED]
[GREEN, RED, RED, BLUE, BLUE, RED]
[GREEN, RED, RED, GREEN, BLUE, RED]
[RED, BLUE, BLUE, GREEN, GREEN, BLUE]
[RED, BLUE, BLUE, RED, GREEN, BLUE]
[RED, BLUE, RED, GREEN, GREEN, BLUE]
[RED, GREEN, GREEN, BLUE, BLUE, GREEN]
[RED, GREEN, GREEN, RED, BLUE, GREEN]
[RED, GREEN, RED, BLUE, BLUE, GREEN]
==========================================================================

Solution: use backtracking to try each combination

    private static String COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
            "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};

    - for current v find unused color index
    - assign to v and call again

    call(v, N)
        if v==N
            print combination
        for c in color
            if c not in adj
                v.color = c
                call v+1, N

*/


import java.util.*;

public class KColorable {

    private static String COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
            "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};

    private static List<List<Integer>> getGraph(int[][] edge, int N) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            List<Integer> li = new ArrayList<>();
            list.add(li);
        }

        for(int[] point: edge) {
            int x = point[0];
            int y = point[1];
            // add 0-1 and 1-0 both
            list.get(x).add(y);
            list.get(y).add(x);
        }
        return list;
    }

    private static Set<String> getAdjC(List<List<Integer>> edge, int src, String[] c) {
        Set<String> hs = new HashSet<>();
        for(int i: edge.get(src)) {
            if(c[i] != "") hs.add(c[i]);
        }
        return hs;
    }

    private static void kColorable(List<List<Integer>> edge, int src,
                                    int k, int N, String[] color) {
        if(src == N) {
            // all pair are colored
            System.out.println(Arrays.toString(color));
            return;
        }

        // each color on vertex, we can assign only first k color
        for(int i=1; i<=k; i++) {
            Set<String> adjColor = getAdjC(edge, src, color);

            // assign color if not in adj
            if(!adjColor.contains(COLORS[i])) {
                color[src] = COLORS[i];
                // call for src+1
                kColorable(edge, src+1, k, N, color);
                // backtrack remove color
                color[src] = "";
            }
        }
    }

    private static void kColorable(int[][] edge, int k, int N) {
        // convert edge to adj list
        List<List<Integer>> graph = getGraph(edge, N);
        String[] color = new String[N];

        // try each vertex each color
        /*
        for(String c: COLORS) {
            HashSet<String> adjColor = getAdjColor(i);
        }
        */
        kColorable(graph, 0, k, N, color);
    }

    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        int[][] arr = new int[][]{
                                    {0, 1}, {0, 4},
                                    {0, 5}, {4, 5},
                                    {1, 4}, {1, 3},
                                    {2, 3}, {2, 4}
                                };

        // Set number of vertices in the graph
        final int N = 6;
        int k = 4;
        // print all k–colorable configurations of the graph
        kColorable(arr, k, N);
    }
}
