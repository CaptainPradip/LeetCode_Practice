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
    ArrayList<Integer> inorderArray = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildBinarySearchTree(0, inorderArray.size() - 1);
    }

    public TreeNode buildBinarySearchTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inorderArray.get(mid));
        root.left = buildBinarySearchTree(start, mid - 1);
        root.right = buildBinarySearchTree(mid + 1, end);
        return root;

    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        this.inorderArray.add(root.val);
        inOrder(root.right);
    }
}