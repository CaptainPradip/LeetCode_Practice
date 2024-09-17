class Solution {
    public int[] findDiagonalOrder(int[][] nums) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer, LinkedList<Integer>> result1 = new HashMap<>();
        queue.add(new int[] { 0, 0 });
        boolean isEven = true;
        while (!queue.isEmpty()) {
            int[] currentNode = queue.remove();
            int row = currentNode[0];
            int col = currentNode[1];
            //if (isEven) {
                result1.computeIfAbsent(row + col, k -> new LinkedList<>()).addLast(nums[row][col]);
            //} else {
              //  result1.computeIfAbsent(row + col, k -> new LinkedList<>()).addFirst(nums[row][col]);
            //}

            result.add(nums[row][col]);
            if (col + 1 < nums[row].length) {
                queue.add(new int[] { row, col + 1 });
            }
            if (col == 0 && row + 1 < nums.length) {
                queue.add(new int[] { row + 1, col });
            }
            isEven= !isEven;

        }
        int[] finalResult = new int[result.size()];
        int i = 0;
        int j =0;
        for (List<Integer> results : result1.values()) {
            if(j%2==0){
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