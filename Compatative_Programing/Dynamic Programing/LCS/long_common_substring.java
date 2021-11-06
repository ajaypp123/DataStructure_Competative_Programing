
/*
s1=abcde
s2=abfce
Output: 2 (ab)
============================
Max=2

    a   b   c   d   e   0
a   2                   0
b       1               0
f                       0
c   0   0   1   0   0   0
e   0   0   0   0   1   0
0   0   0   0   0   0   0

Rules:
if(i==j) {dia + 1 // update max if > than max}

*/

public class long_common_substring {

    private static int LCS(String s1, String s2) {
        int[][] T = new int[s1.length()+1][s2.length()+1];

        int max = 0;
        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {

                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                if(ch1 == ch2) {
                    T[i][j] = T[i-1][j-1] + 1;
                    max = Math.max(max, T[i][j]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int output = LCS(s1, s2);
        System.out.println(output);
    }
}
