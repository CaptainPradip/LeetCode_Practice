class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // 1. first create a HashMap to keep the frequency
        // 2. use sliding window technique

        Map<Character, Integer> frequency = new HashMap<>();
        int maxLength = 0;

        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            char ch = s.charAt(right);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            while (frequency.size() > 2) {
                char leftChar = s.charAt(left);
                frequency.put(leftChar, frequency.get(leftChar) - 1);
                if (frequency.get(leftChar) == 0) {
                    frequency.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}