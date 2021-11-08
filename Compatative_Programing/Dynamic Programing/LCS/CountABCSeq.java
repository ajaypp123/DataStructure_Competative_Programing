import java.util.Arrays;

/*
Given a string, count number of subsequences of the form aibjck, i.e., it consists of i ’a’ characters, followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1.
Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.
Expected Time Complexity: O(n)

Input  : abbc
Output : 3
Subsequences are abc, abc and abbc

Input  : abcabc
Output : 7
Subsequences are abc, abc, abbc, aabc
abcc, abc and abc

*/

public class CountABCSeq {

    private static int patternCount(String str) {

        String pattern = "abc";

        if(str.length() == 0) {
            return 0;
        }

        int[][] T = new int[pattern.length()+1][str.length()+1];
        Arrays.fill(T[0], 1);

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[i].length; j++) {

                if(pattern.charAt(i-1) == str.charAt(j-1)) {
                    T[i][j] = T[i-1][j-1] + (2* T[i-1][j]);
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[pattern.length()][str.length()];
    }

    public static void main(String[] args) {
        System.out.println(patternCount("abcabc"));
    }
}
