class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += countThePalindrom(s, i, i); // odd string
            ans += countThePalindrom(s, i, i + 1); // even string
        }
        return ans;

    }

    private int countThePalindrom(String s, int low, int high) {
        int ans = 0;
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) {
                break;
            }
            low--;
            high++;
            ans++;
        }
        return ans;
    }
}