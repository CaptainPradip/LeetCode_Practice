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
    public boolean isValidBST(TreeNode root) {
     return isValidBST1(root,null,null); 
    }
    public boolean isValidBST(TreeNode root,Integer low, Integer high ){
        if(root==null){
            return true;
        }
        
        if((low != null && root.val<=low) || (high!=null && root.val>=high)){
            return false;
        }
        
        return isValidBST(root.right, root.val, high ) && isValidBST(root.left, low, root.val);
    }
     
    public boolean isValidBST1(TreeNode root, Integer min, Integer max) {
        if(root==null){
            return true;
        }
        if((min!=null && root.val <= min)||(max!=null && root.val >=max)){
            return false;
        }
        
        return isValidBST1(root.right,root.val,max) && isValidBST1(root.left,min,root.val) ;
    }
}


    // public boolean isValidBST(TreeNode root){
        
    //     return isValidBST1(root,null,null);
    // }