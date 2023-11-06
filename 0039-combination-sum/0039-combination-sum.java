class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
     this.backtrack(target,comb,0,candidates,results);
     return results;
        
    }
    public void backtrack(int target,LinkedList<Integer> comb ,int start,int[] candidates, List<List<Integer>> results){
        if(target==0){
            results.add(new ArrayList<Integer>(comb));
            return ;
        } else if(target <0){
            return;
        }
        for(int i= start;i<candidates.length;i++){
            comb.add(candidates[i]);
            this.backtrack(target-candidates[i],comb,i,candidates,results);
            comb.removeLast();
        }
    }
}