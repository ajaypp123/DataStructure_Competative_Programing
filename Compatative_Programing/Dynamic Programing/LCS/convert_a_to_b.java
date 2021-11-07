

/**
 * Given 2 string, apply insertion and deletion and convert
 * s1 to s2
 *
 * s1 = "heap"
 * s2 = "pea"
 * Output "D2I1"
 * ==============
 * find lcs
 *          heap -> pea
 *          heap    -------->  ea --------> pea
 *                  2 delete      1 insert
 *
 */


public class convert_a_to_b {

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aceq";
        String output = ConverAtoB(s1, s2);
        System.out.println(output);
    }

    private static String ConverAtoB(String s1, String s2) {
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

        int d = s1.length() - T[0][0];
        int i = s2.length() - T[0][0];
        return "D" + d + "I" + i;
    }
}
