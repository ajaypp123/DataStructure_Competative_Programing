
/*
Input  :  str = “0102010”
Output : count: 2  length: 3
Explanation : Substring str[2, 4] = “102” and
              substring str[4, 6] = “201” has
              equal number of 0, 1 and 2

Input : str = "102102211"
Output : count: 5 length: 6
*/

// Java program to find substring with equal
// number of 0's, 1's and 2's

import java.util.*;

class CountEqualZOT {


	private static int getSubstringWithEqual012(String str) {
        int count = 0;
        int zc=0, oc=0, tc=0;

        HashMap<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '0':
                    zc++;
                    break;
                case '1':
                    oc++;
                    break;
                case '2':
                    tc++;
                    break;
            }

            String key = (zc - oc) + "#" + (zc - tc);

            // 0102010
            if(map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        return count;

	}

	// Driver Code
	public static void main(String[] args) {
		// Input
		System.out.println("Count: " + getSubstringWithEqual012("0102010"));
        System.out.println("Count: " + getSubstringWithEqual012("102102211"));
	}
}
