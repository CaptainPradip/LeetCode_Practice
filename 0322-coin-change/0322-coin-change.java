class Solution {
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {

       memo = new Integer [amount+1];
       return coinChangeHelper(coins,amount);

    }
    public int coinChangeHelper(int[] coins, int amount) {
        if(amount<0){
            return -1;
        }
        if(amount==0){
            return 0;
        }
        if(memo[amount]!=null) return memo[amount];
        int minCount = Integer.MAX_VALUE;
        for(int coin: coins) {
            int count = coinChangeHelper(coins, amount-coin);
            if(count!=-1){
                minCount=Math.min(minCount,count+1);
            }
        }
        memo[amount] =minCount==Integer.MAX_VALUE ?-1:minCount;
        return memo[amount];
    }

}