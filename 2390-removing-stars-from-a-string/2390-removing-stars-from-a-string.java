class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (stack.isEmpty() || ch != '*') {
                stack.push(ch);
            } else {
                stack.pop();
            }
            j++;
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}