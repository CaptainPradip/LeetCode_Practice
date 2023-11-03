class Solution {

    public int orangesRotting(int[][] grid) {
		int freshOrages = 0;
		int time = 0;
		Deque<ArrayList<Integer>> queue = new ArrayDeque<>();
		// Step 1st Its BFS Problem as we understand use queue;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// Step 2. : add first all Rotten Oranges index in ArrayList
				if (grid[i][j] == 2) {
					queue.add(new ArrayList(Arrays.asList(i, j)));
				}
				// Step 3 : count all Fresh Oranges;
				if (grid[i][j] == 1) {
					freshOrages++;
				}
			}
		}
		// Direction Array
		int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!queue.isEmpty() && freshOrages > 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> currentOrage = queue.remove();
				Integer r = currentOrage.get(0);
				Integer c = currentOrage.get(1);
				// Step 4 : Check with all Direction is any Orange is fresh if
				// yes then make it rotten and reduce freshOrages count
				for (int[] dir : directions) {
					int row = r + dir[0];
					int col = c + dir[1];
					// Check for Boundary Condition
					if (row < 0 || row >= grid.length || col < 0
							|| col >= grid[0].length || grid[row][col] != 1) {
						continue;
					}
					grid[row][col] = 2;
					freshOrages--;
					// Step 5: Add new Rotten Orange in queue;
					queue.add(new ArrayList(Arrays.asList(row, col)));
				}
			}
			// Step 6 : As all Rotten Orange will make adjusted Oranges rotten
			// so
			// its only one time unit
			time++;
		}
		return freshOrages == 0 ? time : -1;
	}

}