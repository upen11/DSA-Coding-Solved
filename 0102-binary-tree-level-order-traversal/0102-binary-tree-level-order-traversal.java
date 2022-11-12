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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        helper(hm, 0, root);
        
        for(int i=0; i<hm.size(); i++) {
            list.add(hm.get(i));
        }
        
        return list;
    }
    
    public static void helper(HashMap<Integer, List<Integer>> hm, int i, TreeNode root) {
        
        if(root == null) return;
        
        if(hm.containsKey(i)) {
            List<Integer> ds = hm.get(i);
            ds.add(root.val);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            hm.put(i, temp);
        }
        
        
        helper(hm, i+1, root.left);
        helper(hm, i+1, root.right);
    }
}