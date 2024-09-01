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
    public int sumNumbers(TreeNode root) {

        return backtracking(root, new ArrayList<>());

    }

    public int backtracking(TreeNode root, List<Integer> list) {

        if (root == null) {
            return 0;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            int sum = 0;
            for (int n : list) {
                sum = sum * 10 + n;
            }
            list.removeLast();
            return sum;
        }

        int leftSum = backtracking(root.left, list);
        int rightSum = backtracking(root.right, list);
        list.removeLast();
        return leftSum + rightSum;

    }
}