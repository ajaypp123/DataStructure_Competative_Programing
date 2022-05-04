class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> li = new LinkedList<>();
        
        if(rowIndex == 0) {
            li.add(1);
            return li;
        }
        
        li.add(1);
        li.add(1);
        if(rowIndex == 1) {
            return li; 
        }
        
        for(int i=2; i<=rowIndex; i++) {
            List<Integer> l = new LinkedList<>();
            l.add(1);
            for(int j=1; j<li.size(); j++) {
                l.add(li.get(j-1) + li.get(j));
            }
            l.add(1);
            li = l;
        }
        return li;
    }
}