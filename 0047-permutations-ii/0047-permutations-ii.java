class Solution {
    List<List<Integer>> result = new ArrayList<>();
     HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        boolean[] visited = new boolean [nums.length];

        backTracking(new LinkedList<>(), nums,visited);

        return new ArrayList<>(set); 
    }
    public void backTracking(LinkedList<Integer> permutations, int[] nums,boolean[] visited){

        if(permutations.size() == nums.length){
            set.add(new ArrayList<>(permutations));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(!visited[i]){
                permutations.add(nums[i]);
                visited[i]=true;
                backTracking(permutations,nums,visited);
                permutations.removeLast();
                 visited[i]=false;
            }
               

        }
    }
}