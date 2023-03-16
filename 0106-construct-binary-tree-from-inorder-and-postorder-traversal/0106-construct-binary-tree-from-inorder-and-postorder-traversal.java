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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd) {
        if (poStart > poEnd) return null;

        TreeNode root = new TreeNode(postorder[poEnd]);

        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[poEnd]) {
                break;
            }
        }

        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = helper(inorder, postorder, inStart, i - 1, poStart, poStart + leftSize - 1);
        root.right = helper(inorder, postorder, i + 1, inEnd, poEnd - rightSize, poEnd - 1);

        return root;
    }
}
