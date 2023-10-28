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
        List<Integer> result = new ArrayList<>();
       
        return  DFS(root);
    }
    public List<Integer> DFS(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> leftList =  DFS(root.left);
        List<Integer> rightList =  DFS(root.right);
        List result = new ArrayList<>();
        result.add(root.val);
        result.addAll(leftList);
        result.addAll(rightList);
        return result; 
    }
    
}