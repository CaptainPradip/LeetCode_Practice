class Solution {
    int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int orangesRotting(int[][] grid) {
        int time = 0;
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.remove();
                for (int[] direction : directions) {
                    int newRow = currentNode[0] + direction[0];
                    int newCol = currentNode[1] + direction[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshOranges--;
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }
            time++;
        }
        return freshOranges == 0 ? time : -1;
    }
}