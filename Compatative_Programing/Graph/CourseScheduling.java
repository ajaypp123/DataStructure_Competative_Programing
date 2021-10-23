
/*
Course Scheduling

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

=================================================
It is cycle detection in directed graph problem

*/

import java.util.*;

public class CourseScheduling {

    private static List<List<Integer>> getMap(int[][] edge, int N) {
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
        }
        return list;
    }

    private static boolean DFS(List<List<Integer>> map, int src, int[] visited) {
        // already visited but not completed
        if(visited[src] == 1) {
            return true;
        }
        if(visited[src] == -1) {
            return false;
        }
        boolean cycle = false;

        // mark visited and complete adj work
        visited[src] = 1;
        for(int adj: map.get(src)) {
            cycle = DFS(map, adj, visited);
            if(cycle == true) {
                break;
            }
        }

        visited[src] = -1;

        // if cycle is true then course can not be finished
        return !cycle;
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        // detect cycle using dfs
        List<List<Integer>> map = getMap(prerequisites, numCourses);
        int[] visited = new int[numCourses];
        boolean isCycle = false;

        for(int i=0; i<numCourses; i++) {
            if(visited[i]==0) {
                isCycle = DFS(map, i, visited);
                if(isCycle) {
                    break;
                }
            }
        }
        return isCycle;
    }

	public static void main(String[] args) {
        // Without Cycle
		int points1[][] = new int[][]{{0,1}, {0,3},{1,2}, {2,3}, {4,3},{4,5},{4,6},{5,6}};
		System.out.println("Output: " + canFinish(7, points1));

        // With Cycle
        // 4 - 5 - 6 -4
		int points2[][] = new int[][]{{0,1},{0,3},{1,2},{2,3},{4,3},{4,5},{6, 4},{5,6}};
		System.out.println("Output: " + canFinish(7, points2));
	}
}
