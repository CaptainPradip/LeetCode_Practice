class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long squre = mid * mid;

            if (squre == x) {
                return (int) mid;
            }
            if (squre > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left * left > x) {
            return (int) left - 1;
        }
        return (int) left;

    }
}