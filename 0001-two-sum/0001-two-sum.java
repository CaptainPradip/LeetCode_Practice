class Solution { 
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] result = new int [2];
        // [2,7,11,15]
        for(int i=0; i< nums.length;i++){
            int key = target - nums[i]; // 9-7
            if(map.containsKey(key)){
                result[0] = map.get(key);
                result[1] = i;
                return result;
            } else{
                map.put(nums[i],i);// 2,0
            }
        }
        return result;
     
    }
}