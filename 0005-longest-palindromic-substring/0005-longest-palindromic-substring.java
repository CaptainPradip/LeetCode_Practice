class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1)
            return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = getLengthOfPalindrome(s, i, i);
            int l2 = getLengthOfPalindrome(s, i, i + 1);
            int length = Math.max(l1, l2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int getLengthOfPalindrome(String s, int startWith, int endsWith) {
        int left = startWith;
        int right = endsWith;
        while (left >= 0 && right < s.length()
                && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }
        return right - left - 1;

    }
}