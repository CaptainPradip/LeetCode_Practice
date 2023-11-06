class Solution {
    // Backtracking

    List<List<Integer>> result= new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> permution = new LinkedList<>();
        blacktrack(permution,nums);
        return result;
    }
    public void blacktrack(LinkedList<Integer> permutation, int[] nums){
        if(permutation.size()==nums.length){
             result.add(new ArrayList<>(permutation)); // Note create a new arraylist deep copy
             return;
        }
        for(int num: nums){
            if(!permutation.contains(num)) { // check for duplication 
                permutation.add(num);
                blacktrack(permutation,nums);
                permutation.removeLast();
            }

        }
    }
}