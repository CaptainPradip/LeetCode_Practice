class Solution {
    int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(i + "," + j)) {
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;

    }

    public void DFS(char[][] grid, int i, int j, Set<String> visited) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[] { i, j });
        visited.add(i + "," + j);
        while (!stack.isEmpty()) {
            int[] currentNode = stack.pop();
            for (int[] neighbor : directions) {
                int row = currentNode[0] + neighbor[0];
                int col = currentNode[1] + neighbor[1];
                if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[row].length - 1
                        || visited.contains(row + "," + col) || grid[row][col]=='0') {
                    continue;
                }
                stack.push(new int[] { row, col });
                visited.add(row + "," + col);
            }
        }
    }
}