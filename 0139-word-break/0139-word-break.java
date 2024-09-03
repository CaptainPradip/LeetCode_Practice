class Solution {

    Map<String,Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {

        if(memo.containsKey(s)){
            return memo.get(s);
        }

        if (s.isEmpty()) {
            return true;
        }
        for (String word : wordDict) {
            boolean startWith = s.startsWith(word);
            if(startWith){
                String sufix = s.substring(word.length());
                if(wordBreak(sufix, wordDict)){
                    memo.put(sufix,true);
                    return true;
                }
            }

        }
        memo.put(s,false);
        return false;

    }
}