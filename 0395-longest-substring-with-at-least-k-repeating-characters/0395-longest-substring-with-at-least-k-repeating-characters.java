class Solution {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while (start < n) {
            char ch = s.charAt(start);
            if (frequency.get(ch) < k) {
                maxLength = Math.max(maxLength, start - left - 1);
                while (left < start) {
                    frequency.put(s.charAt(left), frequency.get(s.charAt(left) - 1));
                    left++;
                }
                left = start;
            } else {
                maxLength = Math.max(maxLength, start - left + 1);
            }
            start++;
        }
        return maxLength;
    }
}