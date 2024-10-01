class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int distance = 1;
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[] { 0, 0 });
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.remove();
                if (currentNode[0] == m - 1 && currentNode[1] == n - 1) {
                    return distance;
                }
                for (int[] node : getNeigbours(currentNode[0], currentNode[1], grid)) {
                    if (!visited[node[0]][node[1]]) {
                        queue.add(node);
                        visited[node[0]][node[1]] = true;
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public List<int[]> getNeigbours(int row, int col, int[][] grid) {
        int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, 1 }, { 1, 1 }, { 1, 0 },
                { 1, -1 }, { 0, -1 } };
        List<int[]> neigbours = new ArrayList<>();
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] != 1) {
                neigbours.add(new int[] { newRow, newCol });
            }
        }
        return neigbours;
    }
}