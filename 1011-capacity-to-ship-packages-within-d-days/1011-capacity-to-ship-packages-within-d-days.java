class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        int res = right;
        while (left <= right) {
            int cap = (left + right) / 2;

            if (canShip(cap, weights, days)) {
                res = Math.min(res, cap);
                right = cap - 1;
            } else {
                left = cap + 1;
            }
        }
        return res;
    }

    public boolean canShip(int cap, int[] weights, int days) {
        int ships = 1;
        int currentCap = cap;
        for (int w : weights) {
            if (currentCap - w < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currentCap = cap;
            }
            currentCap -= w;
        }
        return true;
    }
}