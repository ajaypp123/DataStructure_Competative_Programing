class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        
        if(digits.length() == 0) return list; 
        
        String[] strList = {"", "abc", "def", "ghi", "jkl", 
                        "mno", "pqrs", "tuv", "wxyz"};
        
        solve(digits, strList, 0, "", list);
        return list;
    }
    
    private void solve(String digits, String[] strList, int i, String res, List<String> list) {
        if(i >= digits.length()) {
            list.add(res);
            return;
        }
        
        String a = strList[(digits.charAt(i) - '0') - 1];
        for(char ch: a.toCharArray()) {
            solve(digits, strList, i+1, res + ch, list);
        }
    }
}