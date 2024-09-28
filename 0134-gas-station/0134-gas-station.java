class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if you have gas with buying all gas with the cost that means you can travel
        // to circular thats it.
        // we need to find the starting point if you dont have the gas then your that
        // point will be next point

        int startPoint = 0;
        int currentGas = 0;
        int totalGas = 0;
        for (int i = 0; i < cost.length; i++) {
            currentGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startPoint = i + 1;
            }
        }
        return totalGas < 0 ? -1 : startPoint;

    }
}