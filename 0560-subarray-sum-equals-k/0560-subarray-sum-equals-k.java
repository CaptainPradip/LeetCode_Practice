class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int i = 0;
        int n = nums.length;
        int sum = 0;
        prefixSum.put(0, 1);
        int count = 0;
        while (i < n) {
            sum += nums[i];
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
            i++;
        }
        return count;
    }
}