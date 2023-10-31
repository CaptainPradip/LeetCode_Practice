class Solution {
    public int removeElement(int[] nums, int val) {
        // [0,1,2,2,3,0,4,2]
        int left =0;
        int right =0 ;
        int n = nums.length;
        while(right<n){
            // check the value is same with val 
            if(nums[left]==val && nums[right]!=val){
                nums[left] = nums[right];
                nums[right] = val;
                left++;
            }
            if(nums[left]!=val){
                left++;
            }
            right++;
        }
        return left;
    }
}