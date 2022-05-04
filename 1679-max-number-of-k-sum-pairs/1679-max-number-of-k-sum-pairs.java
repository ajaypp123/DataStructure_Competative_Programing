class Solution {
    public int maxOperations(int[] nums, int k) {
        int total = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        if(k%2==0 && map.containsKey(k/2)) {
            total += (k%2==0 && map.containsKey(k/2))?map.get(k/2)/2:0;
            map.remove(k/2);
        }
        
        for(int i: map.keySet()) {
                total += Math.min(map.get(i), map.getOrDefault(k-i, 0));
                map.put(i, 0);
        }
        
        return total;
    }
}