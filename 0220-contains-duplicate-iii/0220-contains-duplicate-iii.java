class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i =0; i< nums.length;i++){
            Integer s = set.ceiling(nums[i]);
            if(s!=null && (long) s - nums[i] <= valueDiff){
                return true;
            }
            Integer g = set.floor(nums[i]);
            if(g!=null && nums[i] - g <= valueDiff){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>indexDiff){
                set.remove(nums[i-indexDiff]);
            }
        }
        return false;
    }
}