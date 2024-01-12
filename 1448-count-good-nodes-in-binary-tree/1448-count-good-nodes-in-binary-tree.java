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
    public int goodNodes(TreeNode root) {
        
        return  getGoodNodes(root,root.val);
    }
    public int getGoodNodes(TreeNode root, int maxValue){
        if(root==null){
            return 0;
        }
        if(root.val>=maxValue ){
            return 1 +  getGoodNodes(root.left,Math.max(root.val,maxValue)) + getGoodNodes(root.right,Math.max(root.val,maxValue));
        }
          return  getGoodNodes(root.left,Math.max(root.val,maxValue)) + getGoodNodes(root.right,Math.max(root.val,maxValue));

    }
}