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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, result, 0);
        return result;
    }

    public void helper(TreeNode root, List<Integer> result, int index) {
        if (root == null) {
            return;
        }
        if (result.size() > index) {
            result.set(index, root.val);
        } else {
            result.add(root.val);
        }
        helper(root.left, result, index + 1);
        helper(root.right, result, index + 1);
    }
}