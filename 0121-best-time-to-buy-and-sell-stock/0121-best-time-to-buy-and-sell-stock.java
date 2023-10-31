class Solution {
    public int maxProfit(int[] prices) {
      int maxProfit=0;
      int minBuy = Integer.MAX_VALUE;
      for(int price: prices){
          minBuy = Math.min(minBuy,price);
          maxProfit = Math.max(maxProfit,price-minBuy);
      }
      return maxProfit;
    }
}