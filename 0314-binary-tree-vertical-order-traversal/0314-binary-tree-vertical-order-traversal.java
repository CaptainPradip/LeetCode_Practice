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
        queue.add(new Pair(root, column));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.remove();
            TreeNode currentNode = currentPair.getKey();
            column = currentPair.getValue();
            if (currentNode != null) {
                if (!columnMap.containsKey(column)) {
                    columnMap.put(column, new ArrayList<>());
                }
                columnMap.get(column).add(currentNode.val);
                queue.add(new Pair(currentNode.left, column - 1));
                queue.add(new Pair(currentNode.right, column + 1));
            }
        }
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> sortedKeyset = new ArrayList<>(columnMap.keySet());
        Collections.sort(sortedKeyset);
        for(int k : sortedKeyset){
            result.add(columnMap.get(k));
        }
        return result;
    }
}