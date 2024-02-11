class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // [-4,-1,1,2];
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n && diff != 0; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - diff;
    }
}