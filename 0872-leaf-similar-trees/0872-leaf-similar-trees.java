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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        List<Integer> leafNodes2 = new ArrayList<>();
        DFS(root1, leafNodes1);
        DFS(root2, leafNodes2);
        return leafNodes1.equals(leafNodes2);
    }

    public void DFS(TreeNode root, List<Integer> leafNodes) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leafNodes.add(root.val);
            }
            DFS(root.left, leafNodes);
            DFS(root.right, leafNodes);
        }
    }
}