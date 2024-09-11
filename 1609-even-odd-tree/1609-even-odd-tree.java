
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
    public boolean isEvenOddTree(TreeNode root) {

        boolean isEven = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isIncreasing = isEven;
            int prev = Integer.MAX_VALUE;
            if (isEven) {
                prev = Integer.MIN_VALUE;
            }
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if ((isEven && (currentNode.val <= prev || currentNode.val % 2 == 0)) ||
                        (!isEven && (currentNode.val >= prev || currentNode.val % 2 == 1))) {
                    return false;
                }
                prev = currentNode.val;
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            isEven = !isEven;
        }
        return true;
    }
}