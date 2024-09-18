class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int left = 0;
        int right = 1;
     //   while (left < right) {
            int sum = prices[left] + prices[right];
            if(prices[left] + prices[right] <= money){
                return money - (prices[left] + prices[right]);
            }
        
       // }
        return money;
    }
}