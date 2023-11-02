class Solution {
     boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
            || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
    public String reverseVowels(String s) {
        
        
        char [] charArray = s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){

            if(!isVowel(charArray[i])){
                i++;
            }
            if(!isVowel(charArray[j])){
                j--;
            }
            if(isVowel(charArray[i]) && isVowel(charArray[j])){
                char ch = charArray[j];
                charArray[j]=charArray[i];
                charArray[i]=ch;
                i++;
                j--;
            }
        }
        return String.valueOf(charArray);
    }
}