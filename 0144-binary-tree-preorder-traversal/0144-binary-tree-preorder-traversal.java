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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode trav = root;
        List<Integer> result = new ArrayList<>();
        while (trav != null || !stack.isEmpty()) {
            if (trav != null) {
                result.add(trav.val);
                stack.push(trav);
                trav = trav.left;
            } else {
                TreeNode temp = stack.pop();
                trav = temp.right;
            }

        }
        return result;
    }
}