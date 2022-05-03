

class Stock {
    public int w;
    public int h;
}

class Solution {
    
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 1) return heights[0]; 
        int MAX = 0;
        Stack<Stock> stk = new Stack<>();
        int[] res = new int[heights.length];

        // left to right [2,1,5,6,2,3]
        for(int i=0; i<heights.length; i++) {
            Stock st = new Stock();
            st.w = 1;
            st.h = heights[i];

            while(stk.size() != 0 && stk.peek().h >= st.h ) {
                st.w += stk.pop().w;
            }
            res[i] = st.w * st.h;
            stk.push(st);
        }

        stk.clear();

        // rigth to left [2,1,5,6,2,3]
        // left to right [2,1,5,6,2,3]
        for(int i=heights.length-1; i>=0; i--) {
            Stock st = new Stock();
            st.w = 1;
            st.h = heights[i];

            while(stk.size() != 0 && stk.peek().h >= st.h ) {
                st.w += stk.pop().w;
            }
            res[i] = res[i] + (st.w * st.h) - st.h;
            MAX = Math.max(MAX, res[i]);
            stk.push(st);
        }

        return MAX;
    }
}