class Solution {
    public int myAtoi(String s) {
        int sign = 1 ;
        int result = 0;
        int index= 0; 
        int n = s.length();
        // 1. check all white spaces at starting 
        // 2. check the sign 
        // 3. check the traverse until digit 
        // 4. check for the overflow condition result > Integer.MAX_VALUE/ 10 because result * 10 > Integer.MAX_VALUE || result == Integer.MAX_VALUE && digit > Integer.MAX_VALUE%10 as we are adding the digit 
        // 5. result = result*10 + digit ;
        // 6. return sign * result ;

        // 1. 
        while(index < n && s.charAt(index)==' '){
            index++;
        }
        // 2. 
        if(index < n && s.charAt(index) == '+'){
            sign = 1;
            index++;
        } else if(index < n && s.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        // 3 
        while(index< n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) -'0' ; // converts the char to digit 
            // 4.
            if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 5.
            result = 10 * result + digit; 
            index++;
        }
        // 6.
        return sign * result;
        
    }
}