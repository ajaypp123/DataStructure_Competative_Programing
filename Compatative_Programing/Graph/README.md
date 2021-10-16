```
git clean -xdf
```

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

1. Graph connected and Strongly Connected component
    - Connected Component (Undirected Graph)
        - [DFS](ConnectedGraph_3.java)
        - [BFS](ConnectedGraph_3.java)
        - Union Find (Only for undirected graph)
    - Strongly Connected Component (Directed Graph)
        - [Tarjan's Algorithm (***TBD**)](StronglyConnectedTarjan.java)
        - [Kosaraju's Algorithm](StronglyConnectedKosaraju.java)

1. Topological Sorting
    - [DFS](TopologicalSortDFS.java)
    - [BFS (Kahn)](TopologicalSortBFS.java)
    - Problems:
        - There is dependency in graph {0,1} here 1 must complete before 0. then find seq for {{},{},...}

1. [Union Find undirected graph](UnionFind.java)
    - Find Cycle
    - count component
    - Problem:
        - Network Connectivity subset
        - Check if path exist in undirected graph.
        - Subset of same set.

1. Cycle Detection
    - Undirected Graph
        - BFS // Similar to topological sorting consider both edge.
        - DFS // Similar to topological sorting consider both edge.
        - Union Disjoint Set (Covered above)
    - Directed graph
        - [DFS Topological sort](TopologicalSortDFS.java)
        - [BFS Topological sort](TopologicalSortBFS.java)

1. Minimum Cost Spanning Tree
    - Undirected graph
        - [Kruskal](KruskalSpanningTree.java)
        - Prims
    - Directed Graph **TBD**

1. Shortest Path
    - shortest Edge (BFS)
    - [Single source shortest path (Dijkstra)](Dijkstra.java)
        - Find shortest path
    - [Single source shortest path (Bellman Ford)](BellmanFord.java)
        - Find shortest path
        - Check graph it contain negative cycle
    - [All Pair shortest Path]
        - [Floyd Warshall](FloydWarshall.java)
        - Johnson's algorithm ***TBD**
