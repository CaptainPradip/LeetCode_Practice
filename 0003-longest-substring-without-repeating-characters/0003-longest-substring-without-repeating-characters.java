class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding Window
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int longestSeq = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                longestSeq = Math.max(longestSeq, right - left + 1);
                right++;
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return longestSeq;
    }
}