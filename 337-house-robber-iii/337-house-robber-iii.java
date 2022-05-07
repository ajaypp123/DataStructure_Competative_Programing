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

class NodeRes {
    int include = 0;
    int exclude = 0;
    
    public NodeRes() {
        include = 0;
        exclude = 0;
    }
}

class Solution {

    public int rob(TreeNode root) {
        NodeRes res = DFS(root);
        return Math.max(res.include, res.exclude);
    }

    private NodeRes DFS(TreeNode root) {
        if(root == null) return new NodeRes();
        
        NodeRes left = DFS(root.left);
        NodeRes right = DFS(root.right);
        
        NodeRes res = new NodeRes();
        res.include = left.exclude + root.val + right.exclude;
        res.exclude = Math.max(left.include, left.exclude) +  Math.max(right.include, right.exclude);

        return res;
    }
}

