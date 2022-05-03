class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        
        return isScramble(s1, s2, map);
    }
    
    private boolean isScramble(String s1, String s2, HashMap<String, Boolean> map) {
        if(s1.length()==1) {
            return s1.equals(s2);
        }
        
        if(s1.equals(s2)) {
            return true;
        }
        
        String key = s1 + " " + s2;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        
        // abcde = a bcde ,  abcd e
        
        // "abcdbdacbdac"   "bdacabcdbdac"
        boolean result = false;
        for(int i=1; i<s1.length(); i++) {
            
            result = (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                      isScramble(s1.substring(i), s2.substring(i))) 
                        ||
                    (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) && 
                     isScramble(s1.substring(i), s2.substring(0, s2.length()-i)));
            if(result) {
                break;
            }
        }
        
        map.put(key, result);
        return result;
    }
}