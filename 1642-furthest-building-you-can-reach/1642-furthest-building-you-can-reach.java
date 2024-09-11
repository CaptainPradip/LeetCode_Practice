class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> ladderAllocations = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb <= 0) {
                continue;
            }
            ladderAllocations.add(climb);
            if (ladderAllocations.size() <= ladders) {
                continue;
            }
            bricks -= ladderAllocations.remove();
            if (bricks < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}