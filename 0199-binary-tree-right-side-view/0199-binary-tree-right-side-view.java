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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preOrder(root, 1, ans);

        return ans;
    }

    //dfs
    public void preOrder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;

        if (ans.size() < level) ans.add(root.val);

        preOrder(root.right, level + 1, ans);

        preOrder(root.left, level + 1, ans);
    }
    
    // bfs
    /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // List<Integer> level = new LinkedList<>();

            TreeNode node = null;
            
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                
                if (node == null) continue;

                // level.add(node.val);

                if (node.left != null) queue.add(node.left);

                if (node.right != null) queue.add(node.right);
            }

            // ans.add(level.get(level.size() - 1));
            ans.add(node.val);
        }

        return ans;
    }
    */
}
