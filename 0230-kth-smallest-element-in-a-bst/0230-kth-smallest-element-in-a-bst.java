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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode trav = root;

        while (trav != null || !stack.isEmpty()) {
            while (trav != null) {
                stack.push(trav);
                trav = trav.left;
            }
            TreeNode top = stack.pop();
            k--;
            trav = top.right;
            if (k == 0) {
                return top.val;
            }
        }
        return -1;

    }
}