

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

each element can go to s1 or s2

    0   1   2   3

0

1

1

2

3

*/


public class CountSubsetDiff {
    public static void main(String[] args) {
        int[] W = {1, 11, 5, 6};

        int result = subset_sum(W);
        System.out.println(result);
    }

    private static int subset_sum(int[] nums) {
        return 0;
    }
}
