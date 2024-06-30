class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;
        int currentJump = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (currentJump == i) {
                jumps++;
                currentJump = maxJump;
            }
        }
        return jumps;
    }
}