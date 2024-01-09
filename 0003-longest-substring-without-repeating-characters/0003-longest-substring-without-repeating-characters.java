class Solution {
    public int lengthOfLongestSubstring(String s) {
        // we are going to use sliding window 
        // use the set for keeping unique  
        // if you found the character remove left character until that char
        
        int left =0;
        int right=0 ;
        int n = s.length();
        int max = 0;
        Set<Character> set = new HashSet<>();
        while(right < n){
            Character ch = s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right-left + 1 );
            set.add(ch);
            right++;
        }
        return max;
    }
}