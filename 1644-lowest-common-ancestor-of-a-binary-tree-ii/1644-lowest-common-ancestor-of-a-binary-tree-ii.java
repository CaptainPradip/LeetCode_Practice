/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isNodePresent(root, p) && isNodePresent(root, q)) {
            return lowestCommonAncestor1(root, p, q);
        }
        return null;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;

    }

    public boolean isNodePresent(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return isNodePresent(root.left, p) || isNodePresent(root.right, p);
    }
}