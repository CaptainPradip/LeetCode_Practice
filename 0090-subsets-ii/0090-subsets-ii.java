class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> subset = new LinkedList<>();
        Arrays.sort(nums);
         backTrack(0,subset,nums);
         return result;
    }
    public void backTrack(int start, LinkedList<Integer> subset, int [] nums ){
        if(start > nums.length){
            return ;
        }
        result.add(new ArrayList<>(subset));
        for(int i = start;i < nums.length;i++){
            if(i!=start && nums[i]==nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backTrack(i+1,subset,nums);
            subset.removeLast();
        }

    }
}