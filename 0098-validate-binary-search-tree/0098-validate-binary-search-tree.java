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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        TreeNode trav = root;
        while (trav != null || !stack.isEmpty()) {
            while (trav != null) {
                stack.push(trav);
                trav = trav.left;
            }
            trav = stack.pop();
            if (prev != null && trav.val <= prev) {
                return false;
            }
            prev = trav.val;
            trav = trav.right;
        }

        return true;

    }
}