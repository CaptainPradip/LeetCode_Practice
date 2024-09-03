class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int minSize = Integer.MAX_VALUE;
        for (int coin : coins) {
            int remainningAmount = amount - coin;
            int size = coinChange(coins, remainningAmount);
            if (size != -1) {
                if (minSize > size) {
                    minSize = size + 1;
                }

            }
        }
        minSize = minSize == Integer.MAX_VALUE ? -1 : minSize;
        memo.put(amount, minSize);
        return memo.get(amount);
    }
}