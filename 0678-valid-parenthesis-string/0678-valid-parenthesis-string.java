class Solution {
    public boolean checkValidString(String s) {

        int openCount = 0;
        int closeCount = 0;
        int n = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            char leftChar = s.charAt(i);
            if (leftChar == '(' || leftChar == '*') {
                openCount++;
            } else {
                openCount--;
            }
            char rightChar = s.charAt(n - i);
            if (rightChar == ')' || rightChar == '*') {
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