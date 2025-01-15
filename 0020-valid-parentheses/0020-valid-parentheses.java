class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(ch);
                }

            }
        }
        // if(stack.isEmpty())
        return stack.isEmpty() ? true : false;
    }
}