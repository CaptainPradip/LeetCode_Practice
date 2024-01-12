/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int tiltSum = 0;

    public int findTilt1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findTilt1(root.left);
        int right = findTilt1(root.right);
        tiltSum += Math.abs(left - right);
        return root.val + left + right;
    }

    public int findTilt(TreeNode root){
            findTilt1(root);
         return tiltSum;
     }

}