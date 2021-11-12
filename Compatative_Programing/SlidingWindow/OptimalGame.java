
/*
Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.
Note: The opponent is as clever as the user.

 { 20, 30, 2, 2, 2, 10 }
 42
*/

public class OptimalGame {

    private static int maxCostMemoization(int[] arr, int i, int j, boolean turn, int T[][]) {
        // { 20, 30, 2, 2, 2, 10 }
        // 2, 2, 2, 2
        if(j-i == 0) {
            return 0;
        }

        if(T[i][j] != 0) {
            System.out.println("Found");
            return T[i][j];
        }

        int max = 0;
        if(turn) {
            max = Math.max(arr[i] + maxCost(arr, i+1, j, false),
                            arr[j] + maxCost(arr, i, j-1, false));
        } else {
            if(arr[i] > arr[j]) {
                max = maxCost(arr, i+1, j, true);
            } else {
                max = maxCost(arr, i, j-1, true);
            }
        }

        T[i][j] = max;
        return max;
    }

    private static int maxCost(int[] arr, int i, int j, boolean turn) {
        // { 20, 30, 2, 2, 2, 10 }
        // 2, 2, 2, 2
        if(j-i == 0) {
            return 0;
        }

        if(turn) {
            return Math.max(arr[i] + maxCost(arr, i+1, j, false),
                            arr[j] + maxCost(arr, i, j-1, false));
        } else {
            if(arr[i] > arr[j]) {
                return maxCost(arr, i+1, j, true);
            } else {
                return maxCost(arr, i, j-1, true);
            }
        }

    }

    private static int optimalStrategyOfGame(int[] arr, int n) {
        // { 20, 30, 2, 2, 2, 10 }
        return maxCost(arr, 0, arr.length-1, true);
    }

    private static int optimalStrategyOfGameMemoization(int[] arr, int n) {
        // { 20, 30, 2, 2, 2, 10 }
        int[][] T = new int[n][n];
        return maxCostMemoization(arr, 0, arr.length-1, true, T);
    }

    public static void main(String[] args)
    {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println(
            ""
            + optimalStrategyOfGame(arr1, n));
        System.out.println(
            ""
            + optimalStrategyOfGameMemoization(arr1, n));

        int arr2[] = { 2, 2, 2, 2 };
        n = arr2.length;
        System.out.println(
            ""
            + optimalStrategyOfGame(arr2, n));
        System.out.println(
            ""
            + optimalStrategyOfGameMemoization(arr2, n));

        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        n = arr3.length;
        System.out.println(
            ""
            + optimalStrategyOfGame(arr3, n));
        System.out.println(
            ""
            + optimalStrategyOfGameMemoization(arr3, n));
    }
}
