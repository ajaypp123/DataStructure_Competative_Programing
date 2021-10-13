
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

Union Find:
    This method only work on undirected graph.

    Here Union Find is used to create set which have same set of node.
    eg: if 1, 2, 3 are in one component and 4, 5 in other component
    then it create two set {1,2,3} and {4,5}

    It has 3 Method:
    1. MakeSet
        It create single set of each node
    2. Union
        It combine 2 set
    3. Find
        It detect root/parent of node
*/

//import java.util.*;

// G has edge and vertex
class UnionFind_4 {
    public static void main(String[] args) {

    }
}
