class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String str : operations) {
            if (str.equals("+")) {
                int top = stack.pop();
                int newValue = top + stack.peek();
                stack.push(top);
                stack.push(newValue);
            } else if (str.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (str.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        int ans = 0;
        for (int score : stack) {
            ans += score;
        }
        return ans;

    }
}