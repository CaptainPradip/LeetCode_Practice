class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        s = s.replaceAll("[^a-zA-Z0-9]","");
        int j = s.length()-1;
        while(i<=j){
            if(Character.toUpperCase(s.charAt(j))!=Character.toUpperCase(s.charAt(i))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

// s = "A man, a plan, a canal: Panama"
// "amanaplanacanalpanama"
// 