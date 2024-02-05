class Solution {

    int[][] memo;

    public boolean stoneGame(int[] piles) {
        this.memo= new int [piles.length][piles.length];
        return true; //maxStone(piles,0,piles.length-1)>=0;
    }

    public int maxStone(int[] piles, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r] != 0) {
            return memo[l][r];
        }
        int left = piles[l] - maxStone(piles, l + 1, r);
        int right = piles[r] - maxStone(piles, l, r - 1);
        this.memo[l][r] = Math.max(left, right);
        return this.memo[l][r];
    }
}