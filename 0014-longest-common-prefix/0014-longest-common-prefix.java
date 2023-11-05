class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str= strs[0];
        int charIndex=0;
        for(char ch : str.toCharArray()){
            boolean found = true;
            for(int i=1 ; i < strs.length;i++){
                if(strs[i] .length() > charIndex &&  strs[i].charAt(charIndex)!=ch){
                    found=false;
                }
                if(strs[i].length()-1 < charIndex){
                    found=false;
                }
            }
            if(found ){
                sb.append(ch);
                charIndex++;
            }else{
                break;
            }
        }
        return sb.toString();
        
    }
}