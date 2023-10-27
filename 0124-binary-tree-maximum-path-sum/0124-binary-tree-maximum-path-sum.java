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
	int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getPathSum(root);
		return maxPathSum;
    }
	public int getPathSum(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftSum = Math.max(0,getPathSum(root.left));
		int rightSum = Math.max(0,getPathSum(root.right));
		maxPathSum= Math.max(maxPathSum, leftSum + rightSum + root.val);
		return Math.max(leftSum,rightSum) + root.val; 
	}
}