

/*

Return no of call made in last 3000 sec

Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3


===================================================

It is simple queue problem.

add(t)
    add last
    while(last - first > 3000)
        remove first


*/

import java.util.*;

public class RecentCalls {
    LinkedList<Integer> list;

    public RecentCalls() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.addLast(t);

        while((list.getLast() - list.getFirst()) > 3000) {
            list.removeFirst();
        }
        return list.size();
    }
}
