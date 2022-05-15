/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    
    int deep = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        deep = 0;
        postOrder(root, 0, map);
        return map.get(deep);
    }
    
    private void postOrder(TreeNode root, int level, HashMap<Integer, Integer> map) {
        if(root == null) {
            return;
        }
        
        if(root.left == root.right && root.left == null) {
            map.put(level, map.getOrDefault(level, 0) + root.val);
            deep = Math.max(level, deep);
        }
        
        postOrder(root.left, level+1, map);
        postOrder(root.right, level+1, map);
    }
}
