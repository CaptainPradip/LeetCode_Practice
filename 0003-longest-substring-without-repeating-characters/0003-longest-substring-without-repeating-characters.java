class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right < n) {
            char ch = s.charAt(right);
            // change condition
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            // get result condition
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}

// s = "abcabcbb"
// Dyanamic Sliding window
// HashMap or HashSet
// O(n);