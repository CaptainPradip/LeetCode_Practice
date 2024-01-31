class Solution {
    int[][] memo;

    public int lps(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = lps(s, i + 1, j - 1) + 2;
        } else {
            memo[i][j] = Math.max(lps(s, i + 1, j), lps(s, i, j - 1));
        }
        return memo[i][j];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        this.memo = new int[n][n];
        return lps(s, 0, n - 1);
    }
}