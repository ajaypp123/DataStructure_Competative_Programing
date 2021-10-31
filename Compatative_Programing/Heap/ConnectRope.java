
/*
Input:  [5, 4, 2, 8]

Output: The minimum cost is 36

[5, 4, 2, 8] –> First, connect ropes of lengths 4 and 2 that will cost 6.
[5, 6, 8]    –> Next, connect ropes of lengths 5 and 6 that will cost 11.
[11, 8]      –> Finally, connect the remaining two ropes that will cost 19.

Therefore, the total cost for connecting all ropes is 6 + 11 + 19 = 36.

=====================================================================

Solution:
Optimal merge pattern

add array in pq
    pop 2 sum them and put in pq till 1 element in pq

ans pq.peek

*/

public class ConnectRope {

}
