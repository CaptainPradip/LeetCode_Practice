class Solution {
    List<String> result = new ArrayList<>();
    String digits;
    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        this.map.put('2', "abc");
        this.map.put('3', "def");
        this.map.put('4', "ghi");
        this.map.put('5', "jkl");
        this.map.put('6', "mno");
        this.map.put('7', "pqrs");
        this.map.put('8', "tuv");
        this.map.put('9', "wxyz");
        this.digits = digits;
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backTrack(0, new StringBuilder());
        return result;
    }

    public void backTrack(int start, StringBuilder combination) {
        if (combination.length() == this.digits.length()) {
            result.add(combination.toString());
            return;
        }
        String currentLetters = map.get(digits.charAt(start));
        for (char ch : currentLetters.toCharArray()) {
            combination.append(ch);
            backTrack(start + 1, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}