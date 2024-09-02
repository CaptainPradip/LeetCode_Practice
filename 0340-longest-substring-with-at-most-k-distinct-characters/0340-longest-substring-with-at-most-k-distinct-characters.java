 class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0 ;
        int n = s.length();
        int result =0 ;
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()>k){
                int fr = map.get(s.charAt(left)) - 1 ;
                map.put(s.charAt(left),fr);
                if(fr==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            result= Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
}