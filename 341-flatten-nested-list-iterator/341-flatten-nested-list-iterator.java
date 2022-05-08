/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {

    private LinkedList<Integer> list = null;
    private int count;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>();
        flattenIt(nestedList);
        this.count = 0;
    }

    private void flattenIt(List<NestedInteger> nestedList) {
        for(NestedInteger next: nestedList) {
            if(next.isInteger()) {
                list.addLast(next.getInteger());
            } else {
                flattenIt(next.getList());
            }
        }
    }
    
    @Override
    public Integer next() {
        return list.get(this.count++);
    }

    @Override
    public boolean hasNext() {
        return this.count < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */