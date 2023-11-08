class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        double result = Integer.MIN_VALUE; ;
        double sum =0;
        for(int right =0 ;right< n;right++){
            sum +=nums[right];
            if(k==right-left+1){
                result=Math.max(result,sum);
            }
            while(k<=right-left+1){
                sum-=nums[left];
                left++;
            }
        }
        return result/k;
    }
}