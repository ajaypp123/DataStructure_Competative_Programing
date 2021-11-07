
/**
 * str = AABEBCDD
 * output: ABD
 * ========================
 *       s1 = s2 = AABEBCDD
 *       Output = LCS where i!=j
 */

public class long_reapeat_subseq {

    public static void main(String[] args) {
        String s1 = "AABEBCDD";
        String output = LRS(s1);
        System.out.println(output);
    }

    private static String LRS(String s1) {
        String s2 = s1;
        String[][] T = new String[s2.length()+1][s1.length()+1];

        for(int i=s2.length(); i>=0; i--) {
            for(int j=s1.length(); j>=0; j--) {
                T[i][j] = "";
            }
        }

        for(int i=s2.length()-1; i>=0; i--) {
            for(int j=s1.length()-1; j>=0; j--) {
                if(s1.charAt(j) == s2.charAt(i) && i != j) {
                    T[i][j] = String.valueOf(s1.charAt(j)) + T[i+1][j+1];
                } else {
                    T[i][j] = T[i+1][j].length() > T[i][j+1].length()?T[i+1][j]:T[i][j+1];
                    T[i][j] = T[i][j].length() > T[i+1][j+1].length()?T[i][j]:T[i+1][j+1];
                }
            }
        }
        return T[0][0];
    }
}
