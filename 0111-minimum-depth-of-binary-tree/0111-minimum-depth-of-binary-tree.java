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
class Pair {
    TreeNode node;
    int val;
    Pair(TreeNode node , int val){
        this.node = node;
        this.val = val; 
    }
}
class Solution {
   public int minDepth(TreeNode root){
       if(root == null){
           return 0;
       }
     return dfs(root);
   }
    public int dfs(TreeNode root) {
       if(root == null){
           return Integer.MAX_VALUE;
       }
       if(root.left == null && root.right == null){
           return 1;
       }
     int leftDept = dfs(root.left);
     int rightDept = dfs(root.right);

     return 1 + Math.min(leftDept, rightDept) ;
    }
}