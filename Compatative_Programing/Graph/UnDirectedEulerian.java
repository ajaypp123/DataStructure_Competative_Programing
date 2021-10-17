
/*

Undirected graph
================

Eulerian trail (or Eulerian path):
    Problem:
        - An Eulerian trail (or Eulerian path) is a path in a graph that visits every edge exactly once. Given a directed graph, check whether it has an Eulerian path or not.
        - All edge should be visited and traverse exactly once.
        - vertex can be visited again.

    Example:
        new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 1),
        new Edge(1, 4), new Edge(4, 3), new Edge(3, 0), new Edge(0, 5),
        new Edge(5, 4)

    Output: True
        // It has Eulerian path: 0 —> 1 —> 2 —> 3 —> 0 —> 5 —> 4 —> 3 —> 1 —> 4
        // In above path all edges are covered.

    Condition for Eulerian Path:
        1. Degree
            - Exactly zero or two vertex have odd degree.
        2. Connected component
            - All vertex is part of singly connected component.


    Complexity:
        - same as connected component: O(V+E)
================================================================================

Eulerian Cycle:
    Problem:
        - Given a directed graph, check if it is possible to construct a cycle that visits each edge exactly once, i.e., check whether the graph has an Eulerian cycle or not.


    Example: (Add new Edge(4,0))
        new Edge(0, 1), new Edge(1, 2), new Edge(2, 3), new Edge(3, 1),
        new Edge(1, 4), new Edge(4, 3), new Edge(3, 0), new Edge(0, 5),
        new Edge(5, 4), new Edge(4,0)

    Output: True
        // Eulerian Cycle: 0 —> 1 —> 2 —> 3 —> 0 —> 5 —> 4 —> 3 —> 1 —> 4 -> 0
        // In above path all edges are covered.

    Condition for Eulerian Cycle:
        1. Degree
            - Exactly zero vertex have odd degree.
        2. Connected component
            - All vertex is part of singly connected component.

    Complexity:
        - same as connected component: O(V+E)
================================================================================

Semi-Eulerian trail (or Eulerian path):
    - It mean it is eulerian path but not cycle.
    - All condition are same except degree.
    - Condition degree;
        - Exactly two vertex should have odd degree.
================================================================================

*/

class UnDirectedEulerian {

}