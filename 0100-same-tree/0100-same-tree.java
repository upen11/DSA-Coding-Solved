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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.add(p);
        
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.add(q);
        
        while(!stack1.isEmpty()) {
            TreeNode a = stack1.pop();
            TreeNode b = stack2.pop();
            
            if(a == null && b == null) continue;
            
            // if we have one as null and other not
            if(a == null || b == null) return false;
            
            if(a.val != b.val) return false;
            
            stack1.add(a.right);
            stack1.add(a.left);
            
            stack2.add(b.right);
            stack2.add(b.left);
        }
        
        return true;
    }
}