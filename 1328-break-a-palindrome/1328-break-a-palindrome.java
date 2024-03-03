class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        char[] charArr = palindrome.toCharArray();

        if (n == 1) {
            return "";
        }
        for (int i = 0; i < n / 2; i++) {
            if (charArr[i] != 'a') {
                charArr[i] = 'a';
                return String.valueOf(charArr);
            }
        }
        charArr[n - 1] = 'b';
        return String.valueOf(charArr);

    }
}