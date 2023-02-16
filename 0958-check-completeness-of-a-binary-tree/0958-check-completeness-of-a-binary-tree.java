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
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean pastNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            if (pastNull == true && node != null) return false;

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                pastNull = true;
            }
        }

        return true;
    }
}
