class Solution {
    public void moveZeroes(int[] nums) {
       
        int j = 0;
        for(int i =1; i< nums.length;i++){
            if(nums[j] == 0 && nums[i]!=0){
                nums[j] = nums[i];
                nums[i] = 0;
                 j++;
            } 
            if(nums[j]!=0){
                j++;
            }
        }
    }
}