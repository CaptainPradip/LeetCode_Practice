class Solution {
    public int maxProduct(int[] nums) {
        int first = nums[0];
        int second = 0;
        for (int i = 1; i < nums.length; i++) {
            if (first < nums[i]) {
                second = first;
                first = nums[i];
                //continue;
            } else if (second < nums[i]) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}