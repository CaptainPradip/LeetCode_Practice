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
    int rootIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder,int start ,int end ){
        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex++]);
        int inorderIndex = getInOrderIndex(inorder,root.val);
        root.left= buildTree(preorder,inorder,start,inorderIndex-1 );
        root.right= buildTree(preorder,inorder,inorderIndex+1,end );
        return root;

     } 
     public int  getInOrderIndex(int[] inorder ,int data){
         for(int i=0; i<inorder.length;i++){
             if(inorder[i]==data){
                 return i;
             }
         }
         return -1;
     }

}