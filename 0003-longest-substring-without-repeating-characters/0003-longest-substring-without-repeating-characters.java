class Solution {
    public int lengthOfLongestSubstring(String s) {
        
       int left=0;
       int right =0;
       int result =0;
       Set<Character> set = new HashSet<>();
       while(right< s.length()){
           char ch = s.charAt(right);
           while(set.contains(ch)){
               set.remove(s.charAt(left));
               left++;
           }
           result = Math.max(result,right-left+1);
           set.add(s.charAt(right));
           right++;
       }
       return result;
        
    }
}