
/*
How many way brackets can be arranged to make expression true.

===============================================
Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}

mean expression is T ^ F & T put brackets to make it true
================================================

Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
and (T|((T&F)^T)).
*/

/*
public class BooleanParenthesis {

    private static char getResult(char ch1, char ch2, char op) {
        if(op == '^') {
            if(ch1 == ch2) {
                return 'F';
            } else {
                return 'T';
            }
        } else if(op == '|') {
            if(ch1 == 'T' || ch2 == 'T') {
                return 'T';
            }
            return 'F';
        } else {
            // &
            if(ch1 == 'T' && ch2 == 'T') {
                return 'T';
            }
            return 'F';
        }
    }

    private static int totalWays(char symb[], char oper[], int i, int j) {
        // T, T, F, T
        if(j-i <= 0) {
            return 0;
        }

        int count = 0;
        for(int k=i; k<j; k++) {
            char ch1 = totalWays(symb, oper, i, k);
            char ch2 = totalWays(symb, oper, k+1, j);

            count = getResult(ch1, ch2, oper[i]) == 'T'? count+1: count;
        }
        return count;
    }

    private static int countParenth(char symb[], char oper[], int n) {
        if(symb.length == 0) {
            return 0;
        }

        // T, T, F, T
        int i=0, j=symb.length; // k from i to j-1
        int[][] T = new int[symb.length][symb.length];

        for(int i=0; i<T.length; i++) {
            Arrays.fill(T[i], -1);
        }
        return totalWays(symb, oper, i, j);
    }


    public static void main(String[] args) {
        char symbols[] = "TTFT".toCharArray();
        char operators[] = "|&^".toCharArray();
        int n = symbols.length;

        // There are 4 ways
        // ((T|T)&(F^T)), (T|(T&(F^T))),
        // (((T|T)&F)^T) and (T|((T&F)^T))
        System.out.println(
            countParenth(symbols, operators, n));
    }
}
*/