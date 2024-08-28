class Solution {
    int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int rowNumber;
    int colNumber;
    int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         rowNumber = heights.length;
         colNumber = heights[0].length;
         matrix = heights;
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < rowNumber; i++) {
            pacificQueue.offer(new int[] { i, 0 });
            atlanticQueue.offer(new int[] { i, colNumber - 1 });
        }
        for (int i = 0; i < colNumber; i++) {
            pacificQueue.offer(new int[] { 0, i });
            atlanticQueue.offer(new int[] { rowNumber - 1, i });
        }
        boolean[][] pacificVisited = BFS(pacificQueue, new boolean[rowNumber][colNumber]);
        boolean[][] atlanticVisited = BFS(atlanticQueue, new boolean[rowNumber][colNumber]);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        return result;

    }

    private boolean[][] BFS(Queue<int[]> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            visited[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) {
                int newRow = dir[0] + cell[0];
                int newCol = dir[1] + cell[1];
                if (newRow < 0 || newRow >= rowNumber || newCol < 0 || newCol >= colNumber
                        ) {
                    continue;
                }
                if(visited[newRow][newCol]){
                    continue;
                }
                if (matrix[newRow][newCol] >= matrix[cell[0]][cell[1]]) {
                    queue.offer(new int[] { newRow, newCol });
                }
            }
        }
        return visited;

    }
}