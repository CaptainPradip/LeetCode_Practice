class Solution {
    public int[] findDiagonalOrder(int[][] nums) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Map<Integer, LinkedList<Integer>> result = new HashMap<>();
        queue.add(new Pair(0, 0));
        int N = nums.length;
        int M = nums[0].length;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> currentNode = queue.remove();
            int row = currentNode.getKey();
            int col = currentNode.getValue();
            result.computeIfAbsent(row + col, k -> new LinkedList<>()).add(nums[row][col]);

            if (col == 0 && row + 1 < nums.length) {
                queue.add(new Pair(row + 1, col));
            }
            if (col + 1 < nums[row].length) {
                queue.add(new Pair(row, col + 1));
            }
        }
        int[] finalResult = new int[M * N];
        int i = 0;
        int j = 0;
        for (List<Integer> results : result.values()) {
            if (j % 2 == 1) {
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