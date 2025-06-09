class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int mid = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (speedCheck(mid, piles, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean speedCheck(int mid, int[] piles, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / mid);
        }
        return hours <= h;
    }
}