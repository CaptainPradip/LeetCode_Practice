class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(); 
        int left = 0;
        int right = 0;
        int n = s.length();
        int max= Integer.MIN_VALUE;
        int maxFrequency = 0;
        while(right < n){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)) {
				map.put(ch, 0);
			}
			map.put(ch, map.get(ch) + 1);            /*
            map.put(ch, map.getOrDefault(ch, 0) + 1);*/
            maxFrequency = Math.max(maxFrequency,map.get(ch));
            boolean isValid = right - left + 1 - maxFrequency > k ;
            if(isValid) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left++;
            }
            max= Math.max(max,right-left+1);
            right++;
        }

        return max;

    }
}