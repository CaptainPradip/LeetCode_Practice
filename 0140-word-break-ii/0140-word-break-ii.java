class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
         List<String> result = new ArrayList<>();
        if(s.isEmpty()){
            result.add("");
            return result;
        }
      
        for(String str : wordDict){
            if(s.startsWith(str)){
                String prefix = s.substring(str.length(),s.length());
                List<String> sublist = wordBreak(prefix,wordDict);
                for (String sub : sublist) {
                        result.add(str + (sub.isEmpty() ? "" : " ") + sub);      
                }
               
            }
        }
        return result;
    }
}