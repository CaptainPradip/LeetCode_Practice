class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 1. Use BFS
        Queue<int[]> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        queue.add(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int[] currentNode = queue.remove();
            int row = currentNode[0];
            int col = currentNode[1];
            result.add(nums.get(row).get(col));
            if (col == 0 && row + 1 < nums.size()) {
                queue.add(new int[] { row + 1, col });
            }
            if (col + 1 < nums.get(row).size()) {
                queue.add(new int[] { row, col + 1 });
            }
        }
        int[] finalResult = new int[result.size()];
        int i = 0;
        for (int n : result) {
            finalResult[i] = n;
            i++;
        }
        return finalResult;
    }
}