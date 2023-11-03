class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1; i< nums.length;i++){
             int num = nums[i];
             if(num > sub.get(sub.size()-1)){
                 sub.add(num);
             } else{
                 int j=0;
                 while(num>sub.get(j)){
                     j++;
                 }
                 sub.set(j,num);
             }
        }
        return sub.size();
    }
}