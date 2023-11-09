class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int n= nums.length ;
        int count = 0;
        int result = 0 ;// K= 2, count=2, result=5;
        //.           L
        // [1,1,1,0,0,0,1,1,1,1,0],
        //                      R
        for(int right=0;right < n ;right++){
            if(nums[right]==0){
                count++;
            }
            while(count>k){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            
            result= Math.max(result,right-left+1);

        }
        return result;
    }
}