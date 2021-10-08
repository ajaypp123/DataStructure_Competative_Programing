

/*
arr: [1, 1, 2, 3]
Diff: 1

=====================

count s1-s2 = 1
lower:
[]
0

extrem:
[1, 1, 2, 3]
total

Here,
total = 7
s1 - s2 = 1

each element can go to s1 or s2

    0   1   2   3

0   1   0   0   0

1   1

1   1

2

3                   i/j     j-arr[i-1] < 0      [i-1][j]
                            yes T[i-1][j-arr[i-1]]
                            no  T[i-1][j]
                            sum yes+no

*/


public class CountSubsetDiff {
    public static void main(String[] args) {
        int[] W = {1, 11, 5, 6};

        int result = subset_sum(W, 1);
        System.out.println(result);
    }

    private static int subset_sum(int[] nums, int diff) {
        int total = 0;
        for(int i=0; i< nums.length; i++) { total += nums[i]; }

        //Initalize
        int[][] T = new int[nums.length+1][total+1];
        for(int i=0; i< nums.length+1; i++) { T[i][0] = 1; }

        for(int i=1; i< T.length; i++){
            for(int j=1; j< T[0].length; j++){
                if(j-nums[i-1] < 0) {
                    T[i][j] = T[i-1][j];
                } else {
                    T[i][j] = T[i-1][j] + T[i-1][j-nums[i-1]];
                }
            }
        }

        int count = 0;

        for(int j=0; j<T[0].length; j++) {
            //System.out.println(T[T.length-1][j]);
            if(T[T.length-1][j] > 0) {
                if(Math.abs(2*j-total) == diff) {
                    // j-(total-j) = 2j-total == diff
                    count += T[T.length-1][j];
                }
            }
        }

        return count;
    }
}
