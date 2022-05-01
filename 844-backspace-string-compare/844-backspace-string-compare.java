class Solution {
    
    private String getStr(String str) {
        Stack<Character> st = new Stack<>();
        String sb = "";
        
        for(char ch: str.toCharArray()) {
            if(ch == '#' && !st.isEmpty()) {
                st.pop();
            } else if(ch == '#') {
                continue;
            } else {
                st.add(ch);
            }
        }
        
        while(!st.isEmpty()) {
            sb = st.pop() + sb;
        }
        return sb;
    }
    
    public boolean backspaceCompare(String s, String t) {
        return getStr(s).equals(getStr(t));
    }
    
    
}