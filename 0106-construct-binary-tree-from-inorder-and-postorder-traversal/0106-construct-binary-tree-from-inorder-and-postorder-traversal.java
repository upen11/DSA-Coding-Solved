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
        int inLen = inorder.length;
        int poLen = postorder.length;

        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inLen; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(inorderMap, postorder, 0, inLen - 1, 0, poLen - 1);
    }

    public TreeNode helper(Map<Integer, Integer> inorderMap, int[] postorder, int inStart, int inEnd, int poStart, int poEnd) {
        if (inStart > inEnd || poStart > poEnd) return null;

        TreeNode root = new TreeNode(postorder[poEnd]);

        int i = inorderMap.get(root.val);
        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = helper(inorderMap, postorder, inStart, i - 1, poStart, poStart + leftSize - 1);
        root.right = helper(inorderMap, postorder, i + 1, inEnd, poEnd - rightSize, poEnd - 1);

        return root;
    }
}
