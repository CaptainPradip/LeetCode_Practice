
class Solution {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        if (nums.length == 0) {
            return 0;
        }
        while (right < nums.length) {
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
            while (sum < 0 && left <= right) {
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return maxSum;
    }
}