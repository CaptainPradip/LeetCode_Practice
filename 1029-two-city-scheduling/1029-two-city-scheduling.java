class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        
        int totalCost = 0;
        int n = costs.length / 2;
        
        // First n people to city A and the next n people to city B
        for (int i = 0; i < n; i++) {
            totalCost += costs[i][0];  // Send first half to city A
            totalCost += costs[i + n][1];  // Send second half to city B
        }
        
        return totalCost;
    }
}