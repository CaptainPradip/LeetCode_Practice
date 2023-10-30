class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
				int max =0 ;
				int currentEnd = 0 ;
				int jumps=0;
				for(int i=0;i<n-1;i++){
					max = Math.max(max,i+nums[i]);
					if(i==currentEnd){
						jumps++;
						currentEnd=max;
					}
				}
				return jumps;
    }
}