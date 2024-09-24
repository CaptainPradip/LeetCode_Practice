class Solution {
    // public int minAddToMakeValid(String s) {
    // int count = 0;
    // int close = 0;
    // for (int i = 0; i < s.length(); i++) {
    // close += s.charAt(i) == '(' ? 1 : -1;
    // if (close == -1) {
    // count++;
    // close++;
    // }
    // }
    // return count + close;
    // }
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }
}