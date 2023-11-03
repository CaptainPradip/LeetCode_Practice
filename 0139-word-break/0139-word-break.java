class Solution {
    HashMap<String,Boolean> memo= new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        if(s.isEmpty()){
            return true;
        }
        for(String str : wordDict){
            if(s.startsWith(str)){
                String prefix= s.substring(str.length(),s.length());
                if(wordBreak(prefix, wordDict)){
                    memo.put(prefix,true);
                    return true;
                }
            }
        }
        memo.put(s,false);
        return false;
    }
    
}