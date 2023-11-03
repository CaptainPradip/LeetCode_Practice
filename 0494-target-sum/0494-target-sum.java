class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int target) {
         DFS(nums,0, 0,target);
         return count;
    }
    public void DFS(int[] nums, int i , int sum , int target){
        if(i==nums.length){
            if(sum==target){
                count++;
            }
        }else {
            DFS(nums,i+1, sum+nums[i],target);
             DFS(nums,i+1, sum-nums[i],target);
        }
    }
}