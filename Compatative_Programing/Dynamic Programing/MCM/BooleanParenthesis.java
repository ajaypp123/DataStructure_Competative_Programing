
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


public class BooleanParenthesis {

    private static int countParenth(char symb[], char oper[], int n) {
        if(symb.length == 0 || symb.length==1 && symb[0]=='F') {
            return 0;
        }
        if(symb.length==1 && symb[0]=='T')
            return 1;

        int[][] T = new int[symb.length][symb.length];

        return 0;
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
