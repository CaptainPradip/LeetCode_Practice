class Solution {
    int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.remove();
                for (int[] direction : directions) {
                    int newRow = currentNode[0] + direction[0];
                    int newCol = currentNode[1] + direction[1];
                    if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
                            && maze[newRow][newCol] == '.') {
                        if (newRow == 0 || newCol == maze[0].length - 1 || newRow == maze.length - 1 || newCol == 0) {
                            return steps + 1;
                        }
                        queue.add(new int[] { newRow, newCol });
                        maze[newRow][newCol] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}