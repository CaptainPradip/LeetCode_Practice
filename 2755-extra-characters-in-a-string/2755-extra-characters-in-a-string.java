class Solution {
HashMap<String, Integer> memo = new HashMap<>();

    public int minExtraChar(String s, String[] dictionary) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.isEmpty()) {
            return 0;
        }

        int totalExtra = Integer.MAX_VALUE;  // Initialize to a large value

        for (String str : dictionary) {
            boolean startWith = s.startsWith(str);
            if (startWith) {
                String remaininStr = s.substring(str.length());
                int extraChars = minExtraChar(remaininStr, dictionary);
                totalExtra = Math.min(totalExtra, extraChars);
            } else {
                String remaininStr = s.substring(1);
                int extraChars = minExtraChar(remaininStr, dictionary) + 1;
                totalExtra = Math.min(totalExtra, extraChars);
            }
        }

        // Handle the case where no match is found in the dictionary
        totalExtra = (totalExtra == Integer.MAX_VALUE) ? 0 : totalExtra;

        memo.put(s, totalExtra);
        return totalExtra;
    }

}