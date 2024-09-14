class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || Math.abs(stack.peek() - ch) != 32) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}