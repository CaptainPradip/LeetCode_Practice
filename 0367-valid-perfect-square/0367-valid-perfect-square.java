class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2;
        long right = num / 2;
        long mid;
        long squre;
        while (left <= right) {
            mid = left + (right - left) / 2;
            squre = mid * mid;
            if (squre == num) {
                return true;
            }
            if (squre > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}