

/*
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

T[s1.length()][s2.length()]

""  ""          0
"abcdea","ace"   3

    a   b   c   d   e   a   0

a                           0

c                           0

e       1   1   1   1   0   0

0   0   0   0   0   0   0   0

match   T[i][j+1], T[i+1][j+1] + 1
not match   Max(T[i+1][j], T[i][j+1], T[i+1][j+1])

*/



public class print_LC_subseq {

    private static String getString(String s1, String s2, int[][] T) {
        String result = "";

        // "abcde","ace"
        int i=s1.length(), j=s2.length();

        while(i * j != 0) {
            char ch1 = s1.charAt(i-1);
            char ch2 = s2.charAt(j-1);

            if(ch1 == ch2) {
                result = ch1 + result;
                i--; j--;
            } else {
                if(T[i-1][j] > T[i][j-1]) i--; else j--;
            }
        }

        return result;
    }

    private static String LCSMethod2(String s1, String s2) {
        int[][] T = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<T.length; i++) {
            for(int j=1; j<T[0].length; j++) {
                // "abcde", "ace"
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    T[i][j] = 1 + T[i-1][j-1];
                } else {
                    T[i][j] = Math.max( T[i-1][j], T[i][j-1] );
                }
            }
        }

        return getString(s1, s2, T);
    }

    private static String LCSMethod1(String s1, String s2) {
        String[][] T = new String[s2.length()+1][s1.length()+1];

        for(int i=s2.length(); i>=0; i--) {
            for(int j=s1.length(); j>=0; j--) {
                T[i][j] = "";
            }
        }

        for(int i=s2.length()-1; i>=0; i--) {
            for(int j=s1.length()-1; j>=0; j--) {
                if(s1.charAt(j) == s2.charAt(i)) {
                    T[i][j] = String.valueOf(s1.charAt(j)) + T[i+1][j+1];
                } else {
                    T[i][j] = T[i+1][j].length() > T[i][j+1].length()?T[i+1][j]:T[i][j+1];
                    T[i][j] = T[i][j].length() > T[i+1][j+1].length()?T[i][j]:T[i+1][j+1];
                }
            }
        }
        return T[0][0];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        String output = LCSMethod2(s1, s2);
        System.out.println(output);

        output = LCSMethod1(s1, s2);
        System.out.println(output);
    }
}
