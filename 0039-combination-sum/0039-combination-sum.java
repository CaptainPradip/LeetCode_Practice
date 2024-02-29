class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> combination = new LinkedList<>();
        backTrack(target, 0, combination, candidates);
        return result;
    }

    public void backTrack(int target, int start, LinkedList<Integer> combination, int[] candidates) {

        if (target == 0) {
            result.add(new ArrayList<>(combination));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backTrack(target - candidates[i], i, combination, candidates);
            combination.removeLast();
        }
    }
}