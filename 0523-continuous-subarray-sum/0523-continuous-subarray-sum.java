class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int key = sum % k;
            if (!prefixMap.containsKey(key)) {
                prefixMap.put(key, i + 1);
            } else if (prefixMap.get(key) < i) {
                return true;
            }
        }
        return false;
    }
}