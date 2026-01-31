class Solution {
    public int reverse(int x) {

        long reverseNumber = 0;
        boolean sign = false;
        if (x < 0) {
            sign = true;
            x = x * (-1);
        }
        while (x > 0) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        if (reverseNumber > Integer.MAX_VALUE) {
            return 0;
        }

        return sign ? (int) reverseNumber * (-1) : (int) reverseNumber;

    }
}