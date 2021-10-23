
/*
Snake and Ladder Problem

Find the minimum number of throws required to win a given Snake and Ladder game.
=================================================================================
Algorithm:

Map<Integer, Integer> ladder = new HashMap<>();
Map<Integer, Integer> snake = new HashMap<>();

1. We have given ladder and snake, and from 0 we need to each to 100.
2. Dice can move 1..6 position
3. It is simple problem of finding minimum edge from source to destination (BFS)
4. If vertex have snake or ladder then dice edge will not exists.

Create Graph from data from each vertex:
getGraph()
    total_vertex = 10*10;

    for(int i = 1 to 100) {

        if(snake.containsKey(i)) {
            // add snake edge if exits
            i to snake.get(i)
        } else if(ladder.containsKey(i)) {
            // add ladder edge
            i to ladder.get(i)
        } else {
            // dice edge
            i to i+1 .. i+6
        }
    }

solution()

    parent[] // 101  // 0 to 100
    que.add(1 to 6) //initially we can roll dice
    parent[1..6] = 0

    BFS(getGraph(), que, 0//source, 100// destination)

    // after bfs first visited 100 is solution

BFS(source)

    // if edge is going to less number skip it
    // if going 100+ then return
*/

import java.util.*;

// A class to store a graph edge
class Edge {
    int src, dest;

    public Edge(int src, int dest)
    {
        this.src = src;
        this.dest = dest;
    }
}

// A queue node
class Node {
    // stores number associated with graph node
    int ver;

    // `min_dist` stores the minimum distance of a node from the starting vertex
    int min_dist;

    public Node(int ver, int min_dist)
    {
        this.ver = ver;
        this.min_dist = min_dist;
    }
}

// A class to represent a graph object
class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the graph
        for (Edge edge: edges)
        {
            int src = edge.src;
            int dest = edge.dest;

            // Please note that the graph is directed
            adjList.get(src).add(dest);
        }
    }
}

class SnakeLadder
{

    public static void findSolution(Map<Integer, Integer> ladder,
                                    Map<Integer, Integer> snake) {
    // It is 10*10 board, 1 is starting and 100 is ending
    // dice can roll 1 to 6 step
    }

    public static void main(String[] args) {
        // snakes and ladders are represented using a map.
        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        // insert ladders into the map
        ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);

        // insert snakes into the map
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);

        findSolution(ladder, snake);
    }
}