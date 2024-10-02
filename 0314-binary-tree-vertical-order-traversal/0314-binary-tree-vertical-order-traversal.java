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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(new Pair(root, column));
        int minColumn = 0, maxColumn = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.remove();
            TreeNode currentNode = currentPair.getKey();
            column = currentPair.getValue();
            // if (currentNode != null) {
            if (!columnMap.containsKey(column)) {
                columnMap.put(column, new ArrayList<>());
            }
            columnMap.get(column).add(currentNode.val);
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);
            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, column - 1));
            }
            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, column + 1));
            }

            // }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minColumn; i <= maxColumn; ++i) {
            result.add(columnMap.get(i));
        }
        return result;
    }
}