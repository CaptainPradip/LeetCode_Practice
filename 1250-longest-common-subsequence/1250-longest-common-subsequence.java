class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int [text1.length()+1][text2.length()+1];
        for(int i=text2.length()-1;i>=0;i--){
            for(int j = text1.length()-1;j>=0;j--){
                if(text2.charAt(i)==text1.charAt(j)){
                    dp[j][i]= 1 + dp[j+1][i+1];
                } else{
                    dp[j][i]= Math.max(dp[j+1][i],dp[j][i+1]);
                }
            }
        }
        return dp[0][0];
        
    }
}