class Solution {
    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.isEmpty()) {
            return true;
        }
        for (String word : wordDict) {
            boolean isStartWith = s.startsWith(word);
            if (isStartWith) {
                String sufix = s.substring(word.length());
                if (wordBreak(sufix, wordDict)) {
                    memo.put(sufix, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}