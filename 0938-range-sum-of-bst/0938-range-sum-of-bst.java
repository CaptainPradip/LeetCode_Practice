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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return sumBST(root,low ,high, 0);
    }

    public int sumBST(TreeNode root,int low , int high,int sum){
        if(root==null){
            return sum;
        }
        if(root.val >=low && root.val<= high){
            sum+=root.val;
        }
          sum = sumBST(root.right,low,high, sumBST(root.left,low,high,sum));
        return sum;
        

    }
}