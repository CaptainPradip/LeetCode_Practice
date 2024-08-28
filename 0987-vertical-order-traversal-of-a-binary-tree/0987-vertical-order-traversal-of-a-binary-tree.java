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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, List<int[]>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode,Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.add(new Pair(root, column));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> currentPair = queue.remove();
                TreeNode currentNode = currentPair.getKey();
                column = currentPair.getValue();
                if (currentNode != null) {
                    if (!columnMap.containsKey(column)) {
                        columnMap.put(column, new ArrayList<>());
                    }
                    columnMap.get(column).add(new int[] { level, currentNode.val });
                    queue.add(new Pair(currentNode.left, column - 1));
                    queue.add(new Pair(currentNode.right, column + 1));
                }
            }
            level++;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sortedKeyset = new ArrayList<>(columnMap.keySet());
        Collections.sort(sortedKeyset);
        for (int k : sortedKeyset) {
            Collections.sort(columnMap.get(k),(a,b)-> a[0]==b[0] ? a[1]-b[1]: a[0]-b[0]);
             List<Integer> collectedList = columnMap.get(k).stream()
                                           .map(a -> a[1])
                                           .collect(Collectors.toList());
            result.add(collectedList);
        }
        return result;
    }
}