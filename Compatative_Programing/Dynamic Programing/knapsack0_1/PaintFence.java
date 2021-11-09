

/*
Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.

Input : n = 2 k = 4
Output : 16
We have 4 colors and 2 posts.
Ways when both posts have same color : 4
Ways when both posts have diff color :
4(choices for 1st post) * 3(choices for
2nd post) = 12

Input : n = 3 k = 2
Output : 6
*/

public class PaintFence {

    private static int countPaintFence(int n, int k) {
        if(n*k == 0) {
            return 0;
        }

        int[] sim = new int[n];
        int[] diff = new int[n];
        sim[0] = 0;
        diff[0] = k;

        for(int i=2; i<sim.length; i++) {
            sim[i] = diff[i-1];
            diff[i] = (sim[i-1] + diff[i-1]) * (n-1);
        }

        return sim[sim.length-1] + diff[sim.length-1];
    }


}
