class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closeCount = 0;
        int n = s.length() - 1;

        for (int i = 0; i <= n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            if (s.charAt(n - i) == ')' || s.charAt(n - i) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }
            if (openCount < 0 || closeCount < 0) {
                return false;
            }
        }
        return true;

    }
}