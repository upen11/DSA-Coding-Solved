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

    public boolean dfs(TreeNode root, int index, int totalNodes) {
        if (root == null) return true;

        if (index > totalNodes) return false;

        return dfs(root.left, 2 * index, totalNodes) && dfs(root.right, 2 * index + 1, totalNodes);
    }

    // DFS
    public boolean isCompleteTree(TreeNode root) {
        // Total number of nodes
        // DFS --> L.C 2 * i
        //         R.C 2 * i + 1
        
        // if (index > totalNodes) means not complete binary tree

        int totalNodes = countNodes(root);

        return dfs(root, 1, totalNodes);
    }
    
    // BFS
    /*
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
    */
}
