class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        
        for(String word: wordDict) {
            hs.add(word);
        }
        
        List<String> list = new ArrayList<String>();
        solve(s, hs, 0, s.length(), "", list);
        
        return list;
    }
    
    private void solve(String s, HashSet<String> hs, int start, int end, String res, List<String> list) {
        
        if(start == end) { list.add(res.trim()); return; }
        
        for(int i=start; i<end; i++) {
            if(hs.contains(s.substring(start, i+1))) {
                solve(s, hs, i+1, end, res + " " + s.substring(start, i+1) ,list);
            }
        }
        
    }
}