class Solution {
    public int jump(int[] nums) {
        int maxJump =0;
		int n= nums.length;
		int jumpCount=0;
		int currentRange=0;
		for(int i=0; i< n-1;i++){
			maxJump = Math.max(maxJump,i+nums[i]);
			if(currentRange == i){
				 jumpCount++;
				 currentRange = maxJump ;
			}
		}
		return jumpCount;
    }
}