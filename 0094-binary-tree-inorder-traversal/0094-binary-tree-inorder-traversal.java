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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode trav = root;
        while (!stack.isEmpty() || trav != null) {
            if (trav == null && !stack.isEmpty()) {
                TreeNode top = stack.pop();
                result.add(top.val);
                trav = top.right;
            } else {
                stack.push(trav);
                trav = trav.left;
            }
        }
        return result;
    }
}