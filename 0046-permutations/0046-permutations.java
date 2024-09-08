class Solution {
    List<List<Integer>> finalResult;

    public List<List<Integer>> permute(int[] nums) {
        finalResult = new ArrayList<>();
        permutation(new ArrayList<>(), nums);
        return finalResult;
    }

    public void permutation(List<Integer> result, int[] nums) {

        if (result.size() == nums.length) {
            finalResult.add(new ArrayList(result));
        }
        for (int n : nums) {
            if (!result.contains(n)) {
                result.add(n);
                permutation(result, nums);
                result.removeLast();
            }
        }
    }
}