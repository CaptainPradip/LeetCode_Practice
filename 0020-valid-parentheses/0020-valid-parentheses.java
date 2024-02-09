class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0)
            return false;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    if ((top == '(' && ch == ')') || (top == '[' && ch == ']') || (top == '{' && ch == '}')) {
                        stack.pop();
                    } else {
                         return false;
                    }
                } else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}