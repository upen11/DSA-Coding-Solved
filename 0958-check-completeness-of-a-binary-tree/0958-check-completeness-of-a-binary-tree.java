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
        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public boolean isCompleteTree(TreeNode root) {
        //bfs
        // count num of nodes then we will check if there is any who is null in b/w

        int count = countNodes(root);

        System.out.println(count);

        // return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // System.out.println(node.val);

                if (node != null) count--;

                if (node == null && count == 0) return true;

                if (node == null && count > 0) return false;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}
