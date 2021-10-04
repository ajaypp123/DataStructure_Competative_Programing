


/**
 Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.


["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6

["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]
=======================================================================

85          4     85 100         4
70          3     70 80 100       2
60          2     60 8 10       1
80          1     80 100       1
100         0     .100     1
stack
*/

import java.util.*;

class Stock {
    public int p;
    public int index;
    public int result;
}

class StockSpanner {

    Stack<Stock> stk;
    int count;

    public StockSpanner() {
        count = -1;
        stk = new Stack<>();
    }

    public int next(int price) {
        Stock st = new Stock();
        st.index = ++count;
        st.p = price;
        st.result = 1;

        // pop till empty
        while(stk.size() != 0) {
            // peek > st break
            if(stk.peek().p > st.p) {
                break;
            }
            st.result += stk.peek().result;
            stk.pop();
        }
        stk.push(st);
        System.out.println(st.result);
        return st.result;
    }
}

public class StockSpanProblem {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
        stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        stockSpanner.next(85);  // return 6
    }
}
