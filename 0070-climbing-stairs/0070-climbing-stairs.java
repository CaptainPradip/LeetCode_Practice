class Solution {
    int climbStairs(int n){
    int[] memo = new int [n+1];
        return climbStairs( n, memo);
    }
    public int climbStairs(int n, int[] memo) {
        if(memo[n]!=0){
            return memo[n];
        }
        if(n==0) {
             memo[n]= 0;
            return memo[n];
        }
        if(n==1) {
          memo[1] = 1;
          return memo[n];
        }if(n==2) {
             memo[n]= 2;
            return  memo[n];
        }
        memo[n]= climbStairs(n-1,memo) + climbStairs(n-2,memo);
        return memo[n];
    }
}