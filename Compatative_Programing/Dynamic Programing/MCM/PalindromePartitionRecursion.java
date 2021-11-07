
/**
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.

For example, “a|babbbab|b|ababa” is a palindrome partitioning of “ababbbabbababa”.


 * str = nitin
 * Output = 0
 */
/*
(str, i, j)
if(i>j) {
    re 0
}

i==j
    T[i][j] = 0

if(isP(str.substring(i, j+1))) {
    T[i][j] = 0
    return 0
}

min = MAX
for(k=i to k<j) {
    T[i][k] = (str, i, k)
    T[k+1][j] = (str, k+1, j)
    T[i][j] = [i][k] + [k+1][j] + 1
}
re T[i][j]
*/

import java.util.*;

public class PalindromePartitionRecursion {

    private static int panMinPart(String str) {
        // ababbbabbababa
        int i=0, j=str.length()-1;
        int[][] T = new int[str.length()][str.length()];
        for(int p=0; p<T.length; p++) {
            Arrays.fill(T[p], -1);
        }
        return partitionCount(str, i, j, T);
    }

    private static int partitionCount(String str, int i, int j, int[][] T) {
        // ababbbabbababa
        if(j-1 <= 0 || isPalindrome(str, i, j)) {
            //T[i][j] = 0;
            //return T[i][j];
            return 0;
        }

        //if(T[i][j] != -1) {
        //    return 0;
        //}

        int min = Integer.MAX_VALUE;
        // i to k, k+1 to j
        for(int k=i; k<j; k++) {
            int x = partitionCount(str, i, k, T);
            int y = partitionCount(str, k+1, j, T);

            min = Math.min(min, x + y + 1);
        }
        //T[i][j] = min;
        //return T[i][j];
        return min;
    }

    static boolean isPalindrome(String string, int i, int j) {
      while(i < j)
      {
        if(string.charAt(i) != string.charAt(j))
          return false;
        i++;
        j--;
      }
      return true;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";

        int min = panMinPart(str);
        System.out.println(min);
    }
}
