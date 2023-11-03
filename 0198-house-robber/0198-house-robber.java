class Solution {
    public int rob(int[] nums) {
        int t1=0;
        int t2=0;
        for(int i = 0;i<nums.length;i++) {
            int temp = t1;
            int current = nums[i];
            t1= Math.max(t1, current+ t2);
            t2 = temp;
        }
        return t1;
    }
}



// 1 , 3,4,2,6,7 

// 1
// 4 , 2, 6 ,7 
// 3, 2,6,7, 

