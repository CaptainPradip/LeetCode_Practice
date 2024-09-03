class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * r;
            r *= nums[i];
        }
        return result;
    }
}