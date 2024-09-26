class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            if (nums[j] != val ) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i ;
    }
}