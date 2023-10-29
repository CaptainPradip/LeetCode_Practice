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
    int rootIndex = 0; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  buildTree(preorder,inorder , 0, inorder.length-1);
    }
    public TreeNode buildTree(int [] preorder,int[] inorder , int start, int end) {
        if(start > end){
            return null;
        }

        TreeNode root = new TreeNode(preorder[rootIndex++]);
        int nextRootIndex = getNextRootIndex(root.val,inorder,start,end);
        root.left = buildTree(preorder,inorder , start, nextRootIndex-1);
        root.right = buildTree(preorder,inorder , nextRootIndex+1, end);
        return root;
    }

   public int getNextRootIndex(int data, int [] inorder,int start,int end){
        for(int i=start; i<= end;i++){
            if(data==inorder[i]){
                return i;
            }
        }
        return -1;
    }
}