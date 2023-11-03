class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int max1 = simpleRob(nums,0,nums.length-2);
        int max2 = simpleRob(nums,1,nums.length-1);
        return Math.max(max1,max2);
    }

    public int simpleRob(int[] nums,int start,int end){
        int t1=0;
        int t2=0;
        for(int i = start;i<=end;i++) {
            int temp = t1;
            int current = nums[i];
            t1= Math.max(t1, current+ t2);
            t2 = temp;
        }
        return t1;
    }
}