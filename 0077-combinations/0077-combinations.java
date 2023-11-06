class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    int k; 
    public List<List<Integer>> combine(int n, int k) {
       this.n = n;
       this.k = k;
    LinkedList<Integer> combination = new LinkedList<>();
       backTrack(1,combination);
       return result;
    }
    public void backTrack(int start, LinkedList<Integer> combination){
        if(combination.size() == this.k ){
            result.add(new ArrayList<>(combination));
        }
        for(int i = start; i <= this.n; i++) {
            combination.add(i);
            backTrack(i+1,combination);
            combination.removeLast();
        }
    }
}