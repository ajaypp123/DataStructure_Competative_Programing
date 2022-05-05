class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        solve(s, 0, s.length(), new ArrayList<>(), result);
        
        return result;
    }
    
    private void solve(String s, int start, int end, List<String> res, List<List<String>> ans) {
        
        if(start == end) {
            ans.add(new ArrayList<String>(res));
        }
        
        for(int k=start; k<end; k++) {
            
            if(isPalindrome(s, start, k)) {
                res.add(s.substring(start, k+1));
                
                solve(s, k+1, end, res, ans);
                
                res.remove(res.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int left, int right) {        
        while( left < right ) {
            
            if( str.charAt(left) != str.charAt(right) ) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}