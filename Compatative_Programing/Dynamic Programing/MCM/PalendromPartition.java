
/**
 * str = nitin
 * Output = 2
 */

public class PalendromPartition {
    public static void main(String[] args) {
        String str = "abc";

        int min = panMinPart(str);
        System.out.println(min);
    }

    private static int panMinPart(String str) {
        Integer[][] T = new Integer[str.length()][str.length()];
        return Integer.valueOf(par(str, 0, str.length()-1, T));
    }

    private static int par(String str, int i, int j, Integer[][] T) {
        // nitin
        if(i>j) {
            return 0;
        } else if(i==j) {
            T[i][j] = 0;
            return 0;
        }

        if(T[i][j] != null) {
            return T[i][j];
        }

        if(isPal(str, i, j)) {
            T[i][j] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // nitin
        for(int k=i; k<j; k++) {
            int min1 = T[i][k]!=null?T[i][k]:par(str, i, k, T);
            int min2 = T[k+1][j]!=null?T[k+1][j]:par(str, k+1, j, T);
            min = Math.min(min, min1 + min2 + 1);
            T[i][j] = min;
        }

        return T[i][j];
    }

    static boolean isPal(String str, int i, int j) {
        StringBuffer sb = new StringBuffer(str.substring(i, j+1));
        String str2 = sb.reverse().toString();
        if(str2.equals(str.substring(i, j+1))) {
            return true;
        }
        return false;
    }
}
