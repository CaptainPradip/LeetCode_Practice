class Solution {
    public int maxVowels(String s, int k) {
        // 1. Check Vowel in given window if yes increment the right
        // update max  keep the count 

        int left = 0;
        int right = 0;
        int max = 0;
        int n = s.length();
        int count = 0;
        while(right < n ){
            char ch = s.charAt(right);
            if(ch=='a'||ch=='e'|| ch=='i'|| ch=='o'|| ch=='u' ){
                count++;
            }
            while(right-left+1 == k){
                max= Math.max(max,count);
                  char leftCh = s.charAt(left);
                  if(leftCh=='a'||leftCh=='e'|| leftCh=='i'|| leftCh=='o'|| leftCh=='u' ) {
                        count--;
                   }
                   left++;
            }
            right++;
        }
        return max;
    }
}