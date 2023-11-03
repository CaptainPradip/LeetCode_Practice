class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        long reverse = 0;
        if(x<0) {
            return false;
        }
        int init = x;
        while(x>0){
            reverse=reverse*10+x%10;
            x/=10;
        }
        
    return reverse==init;     
  }
}