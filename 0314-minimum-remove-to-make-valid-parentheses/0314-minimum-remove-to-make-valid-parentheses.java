class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
            i++;
        }
        Set<Integer> removeIndex = new HashSet<>();
        while (!stack.isEmpty()) {
            removeIndex.add(stack.pop());
        }
        String result = "";
        for (int j = 0; j < n; j++) {
            if (!removeIndex.contains(j)) {
                result += s.charAt(j);
            }
        }

        return result;

    }
}