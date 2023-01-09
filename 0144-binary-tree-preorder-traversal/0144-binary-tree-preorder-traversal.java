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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();  
            
            if(currNode != null) {
                list.add(currNode.val);
            
                // right node will be below left so left will get out first
                stack.add(currNode.right);
                stack.add(currNode.left);
            }
            
        }
        
        // list = preOrder(root, list);

        return list;
    }

//     public List<Integer> preOrder(TreeNode root, List<Integer> list) {
//         if (root == null) {
//             return list;
//         }

//         list.add(root.val);
//         preOrder(root.left, list);
//         preOrder(root.right, list);

//         return list;
//     }
}
