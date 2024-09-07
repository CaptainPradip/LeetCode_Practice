class Solution {
    public int findDuplicate(int[] nums) {
        //1. as problem said it should be done using constant space use the linklist cycle method;
        // 
        int slowPointer = nums[0];
        int fastPointer = nums[0];
        do{
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];

        }while(slowPointer!=fastPointer);

        slowPointer = nums[0];
        while(slowPointer!=fastPointer){
            slowPointer = nums[slowPointer];
            fastPointer= nums[fastPointer];
        }
        return fastPointer;


    }
}