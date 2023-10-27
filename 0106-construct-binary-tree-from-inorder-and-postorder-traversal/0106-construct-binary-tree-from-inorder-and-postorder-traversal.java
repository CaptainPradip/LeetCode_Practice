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
    int preOrderIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        preOrderIndex= inorder.length-1;

      return  buildTree(inorder, postorder,0,inorder.length-1);
        
    }
    public TreeNode buildTree(int[] inorder,int [] postorder,int start,int end){

        if(start>end){
            return null;
        }
        TreeNode root = new TreeNode(postorder[preOrderIndex--]);
        if(start==end){
            return root;
        }
        int inorderIndex= getInorderIndex(inorder, start, end,root.val);
        root.right = buildTree(inorder,postorder,inorderIndex+1,end);
        root.left = buildTree(inorder,postorder,start,inorderIndex-1);
        return root;
    }
   public int getInorderIndex(int [] inorder,int start,int end,int data){
       for(int i=start;i<=end;i++){
           if(inorder[i]==data){
               return i;
           }
       }
       return -1;
   }
}