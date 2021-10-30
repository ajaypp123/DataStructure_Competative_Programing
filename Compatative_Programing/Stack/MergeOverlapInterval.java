
/*
Input:  {1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}

Output: {1, 6}, {7, 10}, {12, 15}.

==>
{1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}
{1, 5}, {4, 6}, {7, 8}, {8, 10}, {12, 15}
{1, 6}, {7, 8}, {8, 10}, {12, 15}
{1, 6}, {7, 10}, {12, 15}
*/

import java.util.*;

class Point {
    public int x;
    public int y;

    Point(int p, int q) {
        x = p;
        y = q;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")" ;
    }
}

public class MergeOverlapInterval {

    private static Stack<Point> mergeInterval(int[][] point) {
        Stack<Point> st = new Stack<>();
        st.push(new Point(point[0][0], point[0][1]));

        //{1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}
        for(int i=1; i<point.length; i++) {
            Point top = st.peek();

            // if start interval in range
            if(top.x <= point[i][0] && point[i][0] <= top.y) {
                // modify top start
                top.x = Math.min(top.x, point[i][0]);

                // check top.y
                top.y = Math.max(top.y, point[i][1]);
            } else {
                // add new point
                st.push(new Point(point[i][0], point[i][1]));
            }
        }
        return st;
    }

    public static void main(String[] args) {
        int interval[][] = new int[][] {{1, 5}, {2, 3}, {4, 6}, {7, 8}, {8, 10}, {12, 15}};

        System.out.println(mergeInterval(interval).toString());
    }
}
