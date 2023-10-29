class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int operations=0;
        for(int i=0;i<nums.length;i++){
            int sum = k-nums[i];
            if(map.getOrDefault(sum,0)>=1){
                operations++;
                map.put(sum,map.get(sum)-1);
                continue;
            }
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return operations;
    }
}