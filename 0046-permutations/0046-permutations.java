class Solution {
List<List<Integer>> result= new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> permution = new LinkedList<>();
        blacktrack(permution,nums);
        return result;
    }
    public void blacktrack(LinkedList<Integer> permution, int[] nums){
        if(permution.size()==nums.length){
             result.add(new ArrayList<>(permution));
             return;
        }
        for(int num: nums){
            if(!permution.contains(num)){
                permution.add(num);
                blacktrack(permution,nums);
                permution.removeLast();
            }

        }
    }
}