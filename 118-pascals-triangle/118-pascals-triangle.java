class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        rows.add(firstRow);
        
        if(numRows == 1) {
            return rows;
        }
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j <= i ; j++) {
                // iCj will be equal to iCi-j if j > (i/2)
                if(j > (i/2)) { 
                    row.add(row.get(i-j));
                } 
                // nCr = (n/r) * n-1Cr-1 
                else { 
                    int value = (i * rows.get(i-1).get(j-1))/j;
                    row.add(value);
                }
            }
            rows.add(row);
        }
        return rows;
    }
}
