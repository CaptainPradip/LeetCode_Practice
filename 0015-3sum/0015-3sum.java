class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            
            if(i!=0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int val = nums[i] + nums[left] + nums[right];
                if(val==0){
                     List<Integer> temp = new LinkedList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left++]);
                    temp.add(nums[right--]);
                    result.add(temp);
                    while (left < right && nums[left] == nums[left - 1])
                        ++left;
                    //break;
                } else if(val < 0){
                    left++;
                } else{
                   right--;
                }
            }
          
        }
        return result;
    }
}