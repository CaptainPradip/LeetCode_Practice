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
    int rootIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length-1;
        return buildTree(inorder,postorder,0 ,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder,int[] postorder,int start ,int end){

        if(start>end){
            return null;
        }
   
        //  if(start==end){
        //     return root;
        // }
             TreeNode root = new TreeNode(postorder[rootIndex--]);
        int nextIndex = findIndexInorder(root.val, inorder,start,end);
        root.right = buildTree(inorder,postorder,nextIndex+1 , end);
        root.left = buildTree(inorder,postorder,start , nextIndex-1);
        return root;
    }

    public int findIndexInorder(int data, int [] inorder,int start,int end){
        for(int i=start; i<= end;i++){
            if(data==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}