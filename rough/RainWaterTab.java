


/*
[3, 0, 0, 2, 0, 4]

    3   0   0   2   0   4

    w[i] = min(maxL,maxR) - arr[i]

        0   3   0   0   2   0   4   0
max:        4   4   4   4   4   -1
min:        3   3   3   3   3   3

3   4       4
0   4       4
2   4       4
0   4       4
4   -1      4

*/



public class MaxSubsetSum {

    public static void main(String args[]) {
        System.out.println(minDiff(new int[]{3, 0, 0, 2, 0, 4}));
    }

    private static int minDiff(int[] num) {
        return min;
    }
}