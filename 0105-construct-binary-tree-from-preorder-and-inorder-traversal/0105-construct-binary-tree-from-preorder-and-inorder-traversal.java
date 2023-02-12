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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, inorderMap, 0, preorder.length - 1, 0);
    }

    public TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int start, int end, int idx) {
        if (start > end) return null;

        int val = preorder[idx];
        TreeNode node = new TreeNode(val);

        int i = inorderMap.get(val);

        node.left = helper(preorder, inorderMap, start, i - 1, idx + 1);
        node.right = helper(preorder, inorderMap, i + 1, end, idx + 1 + (i - start));

        return node;
    }
}
