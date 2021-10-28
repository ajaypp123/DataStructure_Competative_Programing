
/*
All Knows celebrity
celebrity don't know anyone
Input:
[i][j] = 1 mean i knows j
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not
know anyone but everyone knows him
===================================================

Approach 1:
Indegree and out-degree array from matrix graph.
if(in[i] == n-1 && out-degree[i]==0)
    i is celebrity
======================================================

Approach 1: Stack

Push all member to stack:
    while(st.size()!=1)
        i = pop()
        j = pop()
        // if i knows j push j else i
        if([i][j]==1)
            push(j)
        else
            push(i)

    ans = pop()
    // check if ans is celebrity
    for(0 to n)
        // if ans knows anyone then return -1 else ans
        [ans][i] == 1
            return -1
    return ans

*/

import java.util.*;

public class CelebrityProblem {

    private static int getCelibrity(int[][] map) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<map.length; i++) {
            st.push(i);
        }

        while(st.size()!=1) {
            int x = st.pop();
            int y = st.pop();
            if(map[x][y]==1) {
                st.push(y);
            } else {
                st.push(x);
            }
        }

        // check if last is celibrity
        int ans = st.pop();
        for(int i=0; i<map.length; i++) {
            if(map[ans][i]==1)
                return -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int MATRIX[][] = { { 0, 0, 1, 0 },
        { 0, 0, 1, 0 },
        { 0, 0, 0, 0 },
        { 0, 0, 1, 0 } };

        System.out.println(getCelibrity(MATRIX));
    }
}
