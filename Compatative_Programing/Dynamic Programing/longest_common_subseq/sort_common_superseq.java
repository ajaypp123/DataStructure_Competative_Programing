


/*
Input: text1 = "abcde", text2 = "aceq"
Output: 6  (abcdeq)

Super seq is string having both seq in it.
=====================
"abcde", "aceq"

Ans: s1.len + s2.len - len(LCS)
*/


public class sort_common_superseq {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aceq";
        int output = SCSuperSeq(s1, s2);
        System.out.println(output);
    }

    private static int SCSuperSeq(String s1, String s2) {
        int[][] T = new int[s2.length()+1][s1.length()+1];

        for(int i=s2.length()-1; i>=0; i--) {
            for(int j=s1.length()-1; j>=0; j--) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    T[i][j] = 1 + T[i+1][j+1];
                } else {
                    T[i][j] = Math.max(Math.max(T[i+1][j], T[i][j+1]), T[i+1][j+1]);
                }
            }
        }
        return s1.length() + s2.length() - T[0][0];
    }
}
