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
    public boolean isCompleteTree(TreeNode root) {
        
        int nodes = count(root);
        
        return dfs(root, 1, nodes);
    }
    
    public int count(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + count(root.left) + count(root.right);
    }
    
    public boolean dfs(TreeNode root, int ind, int nodes) {
        if(root == null) return true;
        
        if(ind > nodes) return false;
        
        return dfs(root.left, ind * 2, nodes) && dfs(root.right, ind * 2 + 1, nodes);
        
    }
}