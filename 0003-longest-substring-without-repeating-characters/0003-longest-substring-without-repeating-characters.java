class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < n) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }
}

// Time O(n)

// s = "abcabcbb"
// dyanamic sliding window
// 2 point left right
// HashMap or Hashset