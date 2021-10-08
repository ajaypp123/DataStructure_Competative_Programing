import java.util.ArrayList;
import java.util.HashSet;

/*
      1   2   3   4
--|-------------------
1 | 0   10  15	20
2 | 5   0	9	10
3 | 6	13	0	12
4 | 8	8	9	0
  |

  path: 1-2-4-3-1
  Output: 10+10+9+6
*/

public class TSP {
    public static void main(String[] args) {
        int[][] A = new A[][]{{0, 10, 15, 20}, {5, 0, 9, 10}, {6, 13, 0, 12},{8, 8, 9, 0}};

        int min = minDis(A, 0);
        System.out.println(min);
    }

    private static int minDis(int A[][], int s) {
        int[][] T = new int[A.length][A.length];
        ArrayList<Integer> hs = new ArrayList<>();
        // 0 1 2 3
        // add all city remain
        for(int i=0; i<A.length; i++) {
            if(i != s) {
                hs.add(i);
            }
        }

        return minDis(A, s, hs, T);
    }

    private static int minDis(int A[][], int s, ArrayList<Integer> hs, int T[][]) {
        //base
        if(hs.size() == 0) {
            return -1;
        } else if(hs.size() == 1) {
            T[s][hs.get(0)] = A[s][hs.get(0)]!=-1?A[s][hs.get(0)]:-1;
            return T[s][hs.get(0)];
        }

        int min = Integer.MAX_VALUE;
        for(int a: hs) {
            hs.remove(new Integer(a));
            int remain_dis = T[s][a]!=0?T[s][a]:minDis(A, a, hs, T);
            hs.add(a);
            T[s][a]
        }

        return min;
    }
}
