class Solution {
    int count= 0;
    Map<Integer,Integer> memo = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
       
        return  backTrack(target,nums);
    }
    public int backTrack(int target, int[] nums){

        if(target==0){
            return 1;
        }
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target < 0){
            return 0;
        }
        int result = 0;
        for(int i = 0 ;i < nums.length;i++){
           result+= backTrack(target-nums[i],nums);
        }
        memo.put(target,result);
        return result;
    }
}