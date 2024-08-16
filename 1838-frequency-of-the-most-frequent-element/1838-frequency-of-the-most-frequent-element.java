class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        long total = 0;
        int n = nums.length;
        int result = 0;
        while (right < n) {
            total += nums[right];
            while ((long)(right - left + 1) * nums[right] - total >  k) {
                total -= nums[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}