
/*
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].


*/

import java.util.*;

class Dis implements Comparable<Dis>{

    public int x;
    public int y;
    public double d;

    Dis(int a, int b) {
        x = a;
        y = b;
        d = Math.sqrt( (x*x) + (y*y) );
    }

    @Override
    public int compareTo(Dis p) {
        if(d < p.d) {
            return 1;
        } else {
            return -1;
        }
    }

}

public class ClosestPoint {
    public int[][] kClosest(int[][] points, int k) {
        // Dis {x,y} add k in pq
        PriorityQueue<Dis> pq = new PriorityQueue<>();

        for(int i=0; i<k; i++) {
            pq.add(new Dis(points[i][0], points[i][1]));
        }

        // add in pq k to end
        for(int i=k; i<points.length; i++) {
            // peek > dis
            Dis p2 = new Dis(points[i][0], points[i][1]);

            if(pq.peek().d > p2.d) {
                pq.remove();
                pq.add(p2);
            }
        }

        // return top
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++) {
            res[i][0] = pq.peek().x;
            res[i][1] = pq.peek().y;
            pq.remove();
        }

        return res;
    }
}
