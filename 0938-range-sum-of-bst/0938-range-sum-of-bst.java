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

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        
        int sum = 0;
        if (root.val > L) { // left child is a possible candidate.
            sum += rangeSumBST(root.left, L, R); 
        } 
        if (root.val < R) { // right child is a possible candidate.
            sum += rangeSumBST(root.right, L, R); 
        } 
        if (root.val >= L && root.val <= R) { // count root in.
            sum += root.val;
        } 
        return sum;
    }
}
