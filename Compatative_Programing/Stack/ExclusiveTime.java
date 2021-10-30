
/*
Exclusive Time Of Functions | Leetcode 636

Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]

    0 start         1 start                 1 end   0 end
        0       1      2       3       4       5       6
cpu consumed by
0:  0,1,6
1:  2,3,4,5

Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.


==============================================================
    0 start         1 start                 1 end   0 end
        0       1      2       3       4       5       6
cpu consumed by
0:  0,1,6
1:  2,3,4,5

simple stack problem

push    (0,1) // start 0
        (0,2)
push    (1,1) // start 1
        (1,2)
        (1,3)
pop     (1,4) // end 1
pop     (0,3) // end 0
*/

public class ExclusiveTime {

}
