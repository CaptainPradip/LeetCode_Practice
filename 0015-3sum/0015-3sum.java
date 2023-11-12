class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // [-1,0,1,2,-1,-4]
        // -4,-1,-1,0,1,2
        Arrays.sort(nums);
         List<List<Integer>> result = new ArrayList<>();
        // sort the array
        // remove duplicate 
        //  got with left and right  pointer and check the sum =0 
        // add the number 
        int n=nums.length;
        for(int i=0; i< n ;i++){
            while(i!=0 &&  i < n && nums[i]==nums[i-1] ){
                i++;
            }
            int left = i+1;
            int right = n-1;
            
            while(left < right){
               int  sum = nums[i]+ nums[left] + nums[right];
               if(sum==0){
                   List<Integer> subResult = new ArrayList(Arrays.asList(nums[i], nums[left++],nums[right--]));
                   while(left< right && nums[left]==nums[left-1]){
                       left++;
                   }
                   result.add(subResult);
               }else if(sum <0){
                   left++;
               }else {
                   right--;
               }
            }
        }
        return result;
    }
}