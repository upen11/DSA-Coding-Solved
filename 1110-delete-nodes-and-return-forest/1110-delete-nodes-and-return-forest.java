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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();

        if (root == null) return ans;

        Set<Integer> toDelete = new HashSet<>();

        for (Integer i : to_delete) {
            toDelete.add(i);
        }

        // ans.add(root);
        // System.out.println(toDelete);

        dfs(root, toDelete, ans);

        if(!toDelete.contains(root.val))
            ans.add(root);

        return ans;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> toDelete, List<TreeNode> ans) {
        if (root == null) return null;

        TreeNode left = dfs(root.left, toDelete, ans);
        TreeNode right = dfs(root.right, toDelete, ans);

        if(left == null) root.left = null;
        if(right == null) root.right = null;

        if (toDelete.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
                root.left = null;
            }
            if (root.right != null) {
                ans.add(root.right);
                root.right = null;
            }
            
            return null;
        }

        return root;
    }
    //         if(left != null || right != null) {
    //             if(left != null && toDelete.contains(left.val)) {
    //                 ans.add(left);
    //                 root.left = null;
    //             }

    //             if(right != null && toDelete.contains(right.val)) {
    //                 ans.add(right);
    //                 root.right = null;
    //             }
    //         }

    // return root;
    // }
}
