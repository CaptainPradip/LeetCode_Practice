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
    int rootIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int n;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 1. Create a map with the value with index
        // 2. create a recursion funtion for the build the tree;
        n = inorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex++]);
        int nextIndex = inorderMap.get(root.val);
        root.left = buildTree(preorder, inorder, start, nextIndex - 1);
        root.right = buildTree(preorder, inorder, nextIndex + 1, end);
        return root;
    }
}