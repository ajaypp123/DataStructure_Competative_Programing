
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

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int output = LCS(s1, s2);
        System.out.println(output);
    }

    private static int LCS(String s1, String s2) {
        int[][] T = new int[s2.length()+1][s1.length()+1];

        for(int i=s2.length()-1; i>=0; i--) {
            for(int j=s1.length()-1; j>=0; j--) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    T[i][j] = 1 + T[i+1][j+1];
                } else {
                    T[i][j] = 0;
                }
            }
        }
        return T[0][0];
    }
}
