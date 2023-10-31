class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        while(right< n){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }
            right++;
        }
        return left+1;
    }
}