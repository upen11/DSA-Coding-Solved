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

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;

        int[] min = new int[] { Integer.MAX_VALUE };

        dfs(root, min, null);

        return min[0];
    }

    public TreeNode dfs(TreeNode root, int[] min, TreeNode prev) {
        if (root == null) return prev;  // return prev. not null

        prev = dfs(root.left, min, prev);

        if (prev != null) {
            int diff = root.val - prev.val; // since it is inorder root val will be greater than prev val
            min[0] = Math.min(diff, min[0]);
        }

        prev = root;

        prev = dfs(root.right, min, prev);
        
        return prev;
    }
}
