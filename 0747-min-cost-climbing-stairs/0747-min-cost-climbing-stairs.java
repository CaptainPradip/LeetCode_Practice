class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int [] dp = new int [cost.length+1];
        for(int i= 2;i< dp.length;i++){
            int takeOneStep = dp[i-1] + cost[i-1];
             int taketwoStep = dp[i-2] + cost[i-2];
              dp[i]  = Math.min(takeOneStep,taketwoStep);
        }
        return dp[dp.length-1];
    }
}

