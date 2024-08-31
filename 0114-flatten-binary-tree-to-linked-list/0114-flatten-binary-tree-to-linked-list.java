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
    public void flatten(TreeNode root) {
        DFS(root);
    }

    public TreeNode DFS(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftNode = DFS(root.left);
        TreeNode rightNode = DFS(root.right);
        if (leftNode != null) {
            leftNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightNode != null) {
            return rightNode;
        }
        if (leftNode != null) {
            return leftNode;
        }

        return root;
    }

}