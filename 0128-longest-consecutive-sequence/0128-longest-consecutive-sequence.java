class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int longestConsecutive = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int currentConsecutive = 1;
                while (numSet.contains(num + 1)) {
                    currentConsecutive += 1;
                    num += 1;
                }
                longestConsecutive = Math.max(longestConsecutive,
                        currentConsecutive);
            }
        }
        return longestConsecutive;
    }
}