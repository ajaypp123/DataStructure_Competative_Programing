

/*
Median Priority Queue

add(int i)
findMedian()

    1. If odd element then middle is median
    2. If even element then avg of 2 middle element.

Note calculate and put like ascending order

*/

import java.util.*;

public class MedianPQ {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    MedianPQ() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    private int findMedian() {
        if(left.size() == right.size()) {
            return ( left.peek() + right.peek() ) / 2;
        }
        return left.peek();
    }

    private void add(int i) {
        // First add then balance as we need to maintain order
        if(left.size() == 0 || right.size() == 0) {
            if(left.size() == 0) left.add(i);
            else right.add(i);
        } else {

            // i < left < i < right < i
            if(i < right.size()) {
                left.add(i);
            } else {
                right.add(i);
            }
        }

        // if right size is grater then balance it
        if(right.size() > left.size()) {
            left.add(right.remove());
            left.add(right.remove());
        }

        // if left size is grater than 2 then balance
        if(left.size() > right.size()+1) {
            right.add(left.remove());
        }
    }

    public static void main(String[] args) {
        MedianPQ mpq = new MedianPQ();

        mpq.add(1);
        System.out.println(mpq.findMedian());
        mpq.add(2);
        System.out.println(mpq.findMedian());
        mpq.add(3);
        System.out.println(mpq.findMedian());
        mpq.add(4);
        System.out.println(mpq.findMedian());
    }
}
