class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] arr = new int[s.length()+1];
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i=2; i<arr.length; i++) {
            int prev = s.charAt(i-2) - '0';
            int curr = s.charAt(i-1) - '0';
            // 00, 0x, x0, xx

            if(curr == 0 && prev == 0) {
                // 00
                return 0;
            } else if(curr == 0 && prev < 3) {
                // 10
                arr[i] = arr[i-2];
                
            } else if(curr == 0 && prev >= 3) {
                //30
                return 0;
            } else if(prev == 0) {
                // 06
                arr[i] = arr[i-1];
            } else if(curr+(prev*10) < 27) {
                // 23
                arr[i] = arr[i-1] + arr[i-2];
            } else {
                arr[i] = arr[i-1];
            }
        }
        
        return arr[arr.length-1];
    }
}