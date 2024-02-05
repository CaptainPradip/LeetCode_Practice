class Solution {
    public int maximumDifference(int[] nums) {
        int min= Integer.MAX_VALUE;
        int diff = -1 ;
        for(int i=0;i< nums.length;i++){
            min = Math.min(min, nums[i]);
            if(min!=nums[i] && min <  nums[i]){
                diff = Math.max(diff,nums[i] - min) ;
            }
        }
        return diff;
    }
}