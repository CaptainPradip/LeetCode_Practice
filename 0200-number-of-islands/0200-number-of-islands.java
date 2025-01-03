class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // call dfs
                    DFS(grid, i, j);
                }

            }
        }
        return count;

    }

    public void DFS(char[][] grid, int i, int j) {

        if (i > grid.length - 1 || i < 0 || j > grid[i].length - 1 || j < 0 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);

    }

}
