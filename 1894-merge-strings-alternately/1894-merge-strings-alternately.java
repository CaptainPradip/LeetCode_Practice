class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length();
        int n = word2.length();
        int N = Math.max(n,m);
        for(int i=0;i< N ;i++){
            if(i< m){
                sb.append(word1.charAt(i));
            }
            if( i< n){
                 sb.append(word2.charAt(i));
            }
        }
        return sb.toString();

    }
}