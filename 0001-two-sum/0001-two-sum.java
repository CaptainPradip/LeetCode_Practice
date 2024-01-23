class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0; i < nums.length;i++) {
            int key = target-nums[i];
            if(hashMap.containsKey(key)){
                return new int []{ hashMap.get(key),i};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[2];
    }
}