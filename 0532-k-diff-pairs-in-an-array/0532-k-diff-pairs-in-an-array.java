class Solution {
    public int findPairs(int[] nums, int k) {
        // 1. use 2 pointer Method ;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int n = nums.length;
        int result = 0;
        while (right < n && left < n) {

            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                result++;
                left++;
                while (left < n && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        return result;
    }
}