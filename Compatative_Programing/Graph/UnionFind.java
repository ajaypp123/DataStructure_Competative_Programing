
/*
Problem:
We have some number of items. We are allowed to merge any two items to consider them equal. At any point, we are allowed to ask whether two items are considered equal or not.

Implement Union Find method
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
									{ 2, 0, 3, 8, 5 },
									{ 0, 3, 0, 0, 7 },
									{ 6, 8, 0, 0, 9 },
									{ 0, 5, 7, 9, 0 } };

=============================================
UnionFind:
    This method only work on undirected graph.

    Here Union Find is used to create set which have same set of node.
    eg: if 1, 2, 3 are in one component and 4, 5 in other component
    then it create two set {1,2,3} and {4,5}

    It has 3 Method:
    1. MakeSet: It create single set of each node
    2. Union: It combine 2 set.
    3. Find: It detect root/parent of node

================================================================

Example:
    makeset(10)
    // created 10 different set
    Set:    0   1   2   3   4   5   6   7   8   9

    Union(0,1)
        0<--1    // 0 is parent
    Union(4, 5)
        4<--5
    Union(5, 6)
        4<--5<--6
    Union(5, 1)
        1-->0--> 4 <--5<--6     // 4 is root // combine to keep height min for tree
            // Find(x), x belong to tree then parent is 4, eg Find(6)=Find(5)=Find(4)=4

=================================================================

Algorithm:
    // set rank 0 and parent point to self
    function MakeSet(x)
        x.parent = x
        x.rank = 0

    // search parent till find root; 1-->0--> 4 <--5<--6 Find(6)=Find(5)=Find(4)=4
    function Find(x)
        if x.parent == x
            return x
        else
            return Find(x.parent)

    function Union(x, y)
        xRoot = Find(x)
        yRoot = Find(y)

        // both have same parent mean already in same set
        if xRoot == yRoot
            return

        // x and y are not already in the same set. Merge them.
        // make lower rank(depth) as parent of highrer rank(deapth)
        if xRoot.rank < yRoot.rank
            xRoot.parent = yRoot
        else if xRoot.rank > yRoot.rank
            yRoot.parent = xRoot
        else
            yRoot.parent = xRoot
            xRoot.rank = xRoot.rank + 1

    --------------------------------------------------------------------

    Parent: 0   1   2   3   4   5   6   7   8   9
    Rank:   0   0   0   0   0   0   0   0   0   0
===============================================================================

Complexity:
    - makeSet: o(n)
    - Union: O(1)
    - Find: O(lon(n)) // for union find by rank and O(n) for without rank

*/

import java.util.*;

class UnionFind {

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

    private static void printSet(int[] parent, int[] rank) {
        for(int i: parent) {
            System.out.print(Find(i, parent) + " ");
        }
        System.out.println();
        for(int i: rank) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    private static void testUnion() {
        int[] parent = new int[10];
        int[] rank = new int[10];

        makeSet(parent, rank);
        printSet(parent, rank);

        Union(1, 3, parent, rank);
        printSet(parent, rank);

        Union(3, 5, parent, rank);
        printSet(parent, rank);

        Union(2, 7, parent, rank);
        printSet(parent, rank);

        Union(3, 2, parent, rank);
        printSet(parent, rank);
    }

    private  static boolean findCycle(int V, int[][] edges) {
        // makeSet
        int[] parent = new int[V];
        int[] rank = new int[V];
        makeSet(parent, rank);

        for(int[] edge: edges) {
            // Check if both point have same parent then there is cycle
            int x = Find(edge[0], parent);
            int y = Find(edge[1], parent);

            if(x==y) {
                // find Cycle
                return true;
            }

            // combine two set
            Union(edge[0], edge[1], parent, rank);
        }
        // No cycle found
        return false;
    }

    private  static HashMap<Integer, ArrayList<Integer>> findComponents(int V, int[][] edges) {
        // makeSet
        int[] parent = new int[V];
        int[] rank = new int[V];
        makeSet(parent, rank);

        // Union all edges and then find total dijoint set
        for(int[] edge: edges) {
            Union(edge[0], edge[1], parent, rank);
        }

        // map: root node -> list of child of root node
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<V; i++) {
            int x = Find(i, parent);
            if(hm.containsKey(x)) {
                hm.get(x).add(i);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                hm.put(x, arr);
            }
        }

        return hm;
    }

    public static void main(String[] args) {
        testUnion();

        // undirected edges cycle exists
        int[][] edged = new int[][]{{1,2},{2,3},{3,4},{5,0},{5,2},{0,4}};
        System.out.println(findCycle(6, edged));

        // undirected edges cycle not exists
        int[][] edged1 = new int[][]{{1,2},{2,3},{3,4},{5,0}};
        System.out.println(findCycle(6, edged1));

        // undirected edges 2 components
        int[][] edged2 = new int[][]{{1,2},{2,3},{3,4},{5,0}};
        System.out.println(findComponents(6, edged2).toString());
    }
}
