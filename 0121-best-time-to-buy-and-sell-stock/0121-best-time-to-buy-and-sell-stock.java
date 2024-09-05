class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minValue = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minValue);
            minValue = Math.min(minValue, price);
        }
        return maxProfit;

    }
}