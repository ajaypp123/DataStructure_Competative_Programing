class Solution {
    
    
    public List<Integer> diffWaysToCompute(String expression) {
        List<Character> op = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        
        int prev = 0;
        for(int i=0; i<expression.length(); i++) {
            char ch = expression.charAt(i);
            
            if(ch == '+' || ch == '*' || ch == '-') {
                op.add(ch);
                num.add(Integer.parseInt(expression.substring(prev, i)));
                prev = i+1;
            }
        }
        num.add(Integer.parseInt(expression.substring(prev, expression.length())));
        
        if(num.size() < 2) {
            return num;
        }

        List[][] dp = new List[num.size()+1][num.size()+1];
        return solve(num, op, 0, num.size()-1, dp);
    }

    private List<Integer> solve(List<Integer> num, List<Character> op, 
                                int start, int end, List[][] dp) {

        if(dp[start][end] != null) return dp[start][end];
            
        if(end == start) {
            List<Integer> li = new ArrayList<Integer>();
            li.add(num.get(start));
            dp[start][end] = li;
            return li;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=start; i<end; i++) {
            List<Integer> leftList = solve(num, op, start, i, dp);
            List<Integer> rightList = solve(num, op, i+1, end, dp);
            
            for(int l: leftList) {
                for(int r: rightList) {
                    res.add(calculate(l, r, op.get(i)));            
                }
            }
        }
        
        dp[start][end] = res;
        return res;
    }
    
    private int calculate(int i, int j, char ch) {
        switch(ch) {
            case '-':
                return i - j;
            case '+':
                return i + j;
            default:
                return i * j;
        }
    }

}










