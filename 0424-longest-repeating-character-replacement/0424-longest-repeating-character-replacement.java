
class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int n = s.length();
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        while (right < n) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(ch));
            boolean isValid = right - left + 1 - maxFrequency > k;
            // condtion for left pointer or sliding window
            if (isValid) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            // result condition
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;

    }
}

// s = "ABAB", k = 2
// s = BBBB
// s = "AABABBA", k = 1
// left = 1
// right= 1