class Solution {
    public int[] findDiagonalOrder(int[][] nums) {
        Queue<int[]> queue = new ArrayDeque<>();
        Map<Integer, LinkedList<Integer>> result = new HashMap<>();
        queue.add(new int[] { 0, 0 });
        int N = nums.length;
        int M = nums[0].length;
        while (!queue.isEmpty()) {
            int[] currentNode = queue.remove();
            int row = currentNode[0];
            int col = currentNode[1];
            result.computeIfAbsent(row + col, k -> new LinkedList<>()).addLast(nums[row][col]);
            if (col + 1 < nums[row].length) {
                queue.add(new int[] { row, col + 1 });
            }
            if (col == 0 && row + 1 < nums.length) {
                queue.add(new int[] { row + 1, col });
            }
        }
        int[] finalResult = new int[M * N];
        int i = 0;
        int j = 0;
        for (List<Integer> results : result.values()) {
            if (j % 2 == 0) {
                Collections.reverse(results);
            }
            for (int n : results) {
                finalResult[i] = n;
                i++;
            }
            j++;
        }
        return finalResult;
    }
}