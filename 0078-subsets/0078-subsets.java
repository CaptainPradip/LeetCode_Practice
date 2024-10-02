class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> subset = new LinkedList<>();
        backtrack(0, subset, nums);
        return result;
    }

    public void backtrack(int start, LinkedList<Integer> subset, int[] nums) {
        // Base Case
        if (start > nums.length) {
            return;
        }
        // Result Case
        result.add(new ArrayList<>(subset)); // IMP Do Deep Copy
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            // Call BackTrack Function
            backtrack(i + 1, subset, nums);
            subset.removeLast(); // Go to Previus step
        }

    }
}