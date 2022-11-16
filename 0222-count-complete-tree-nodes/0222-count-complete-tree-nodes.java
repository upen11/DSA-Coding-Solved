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
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        
        int  height = 1;
        TreeNode l = root, r = root;
        while(l.left != null && r.right != null) {
           height++;  
            l = l.left;
            r = r.right;
        }
        
        if(l==null && r==null) {
            return (int)Math.pow(2, height) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}