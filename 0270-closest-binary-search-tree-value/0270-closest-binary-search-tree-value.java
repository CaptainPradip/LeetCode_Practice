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
    int closeValue = Integer.MAX_VALUE;
    double minValue = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        closestValue(root.left, target);
        double min = Math.abs(root.val - target);
        if (minValue > min) {
            closeValue = root.val;
            minValue = min;
        }
        closestValue(root.right, target);
        return closeValue;
    }
}