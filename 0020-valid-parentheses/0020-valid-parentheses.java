class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            //Opening brace encountered
            if (!map.containsKey(c)) {
                stack.push(c);
            }
            //Closing brace encountered
            else {
                if (!stack.isEmpty() && map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}