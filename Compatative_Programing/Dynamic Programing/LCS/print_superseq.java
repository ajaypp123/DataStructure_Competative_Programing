





/*
Print shortest common Supersequence

Input:
text1 = "abcdaf"
text2 = "acbcf"
Output: acbcdaf

Here s1 and s2 both are in output LCS

==============================

        a   b   c   d   a   f   0
    a   4   3   2   2   2   1   0
    c   3   3   2   1   1   1   0
    b   3   3   2   1   1   1   0
    c   2   2   2   1   1   1   0
    f   1   1   1   1   1   1   0
    0   0   0   0   0   0   0   0

    a
        |
        b
            c
                -   -   -   f
    str = ""
    To find LCS start from T[0][0]
        if(s1[i] == s2[j])
            str +=s1[i]
        else if(s1[i+1]  < s2[j+1])
            update i = i, j=j+1
            continue
        else
            update i = i+1, j=j
            continue

    str = ""
    LCS =
*/


public class print_superseq {

    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "acbcf";
        String output = LCS(s1, s2);
        System.out.println(output);
    }

    private static String LCS(String s1, String s2) {
        int[][] T = new int[s1.length()+1][s2.length()+1];
        String str = "";

        for(int i=s1.length()-1; i>=0; i--) {
            for(int j=s2.length()-1; j>=0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    T[i][j] = 1 + T[i+1][j+1];
                } else {
                    T[i][j] = Math.max(T[i+1][j], T[j+1][i]);
                }
            }
        }

        int i=0, j=0;
        while(i!=s1.length() || j!=s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) {
                str += s1.charAt(i);
                i++; j++;
            } else if(T[i+1][j] > T[i][j+1]) {
                str += s1.charAt(i);
                i=i+1;
            } else {
                str += s2.charAt(j);
                j=j+1;
            }
        }
        return str;
    }
}
