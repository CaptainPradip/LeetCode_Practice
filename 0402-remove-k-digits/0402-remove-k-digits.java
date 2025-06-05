class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (char digit : stack) {
            if (isZero && digit == '0')
                continue;
            isZero = false;
            sb.append(digit);
        }
        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }
}