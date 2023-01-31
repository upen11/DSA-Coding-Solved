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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        int ans[] = { -1 };
        inorderTraversal(root, k, ans, list);

        return ans[0];
    }

    public void inorderTraversal(TreeNode root, int k, int[] ans, List<Integer> list) {
        if (ans[0] != -1) return;

        if (root == null) return;

        inorderTraversal(root.left, k, ans, list);

        list.add(root.val);
        if (list.size() == k) {
            ans[0] = list.get(list.size() - 1);
            return;
        }
        
        inorderTraversal(root.right, k, ans, list);
    }
}
