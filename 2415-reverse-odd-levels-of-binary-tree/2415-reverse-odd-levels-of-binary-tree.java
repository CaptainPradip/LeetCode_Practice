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
    public TreeNode reverseOddLevels(TreeNode root) {
        // reverseOddLevels(root.left, root.right, 1);
        BFS(root);
        return root;
    }

    public void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int level = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
            if (level % 2 == 1 && !queue.isEmpty()) {
                int n = queue.size();
                int[] values = new int[n];
                int i = 0;
                for (TreeNode node : queue) {
                    values[i++] = node.val;
                }
                int j = n - 1;
                for (TreeNode node : queue) {
                    node.val = values[j--];
                }
            }

        }

    }

    public void reverseOddLevels(TreeNode node1, TreeNode node2, int level) {

        if (node1 == null || node2 == null) {
            return;
        }

        if (level % 2 == 1) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        reverseOddLevels(node1.left, node2.right, level + 1);
        reverseOddLevels(node1.right, node2.left, level + 1);

    }
}