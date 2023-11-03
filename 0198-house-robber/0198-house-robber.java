class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        int[] dp = new int [n];
       if(n==1){
         return  nums[0] ;
       }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

}

// 1 , 3,4,2,6,7 

// 1
// 4 , 2, 6 ,7 
// 3, 2,6,7, 

