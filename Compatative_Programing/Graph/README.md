# Graph Competitive Programing

## Content

1. [Implement graph](ImplementGraph_1.java)
    - Metrix Implementation
    - Adjacency List Implementation
    - Points to graph implementation

1. Graph Traversal
    - [Breadth First Search](Traverse_BFS_2.java)
        - Metrix Traverse
        - Points graph traverse
    - [Depth First Search](Traverse_DFS_3.java)
        - Metrix Traverse
        - Points graph traverse
    - Problem:
        - Find min edges distance (BFS)
        - Depth is high, find live member in family tree (DFS)
        - Family tree, parent who died early (BFS)
        - Depth check or longest depth (DFS)
        - Shortest Path (BFS)
        - Maze, Sudoku (DFS)

1. Topological Sorting
    - [DFS]((TopologicalSortDFS.java)
    - [BFS (Kahn)](TopologicalSortBFS.java)
    - Problems:
        - There is dependency in graph {0,1} here 1 must complete before 0. then find seq for {{},{},...}

1. Graph connected and Strongly Connected component
    - Connected Component (Undirected Graph)
        - [DFS](ConnectedGraph_3.java)
        - [BFS](ConnectedGraph_3.java)
        - Union Find (Only for undirected graph)
    - Strongly Connected Component *TBD (Directed Graph)

1. [Union Find undirected graph *TBD](UnionFind_4.java)
    - Find Cycle
    - count component

1. Cycle Detection
    - Undirected Graph
        - BFS
        - DFS
        - Union Disjoint Set (Covered in 4)
    - Directed graph
        - BFS
        - DFS

1. Minimum Cost Spanning Tree
    - Kruskal
    - Prims

1. Shortest Path
    - Single source shortest path (Diskastra)