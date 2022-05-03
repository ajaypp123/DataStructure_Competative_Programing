class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[j] = matrix[i][j] == '1' ? dp[j]+1 : 0;
            }
            int ans = findMaxAreaInHistogram(dp);
            maxArea = Math.max(maxArea, ans);
        }
        return maxArea;
    }
	
    public int findMaxAreaInHistogram(int[] heights){
          int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()){
                left[i] = 0;
                stk.push(i);
            }else{
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[i])
                    stk.pop();
                left[i] = stk.isEmpty() ? 0 : stk.peek()+1;

                stk.push(i);
            }
        }
        stk.clear();
        for (int i = n-1; i >= 0; --i) {
            if (stk.isEmpty()){
                right[i] = n-1;
                stk.push(n-1);
            }else{
                while(!stk.isEmpty() && heights[stk.peek()] >= heights[i])
                    stk.pop();
                right[i] = stk.isEmpty() ? n-1 : stk.peek()-1;
                stk.push(i);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i]*(right[i]-left[i] + 1));
        }
        return max;
    }
}