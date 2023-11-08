class Solution {
    public String removeStars(String s) {
        Stack<Character> stack= new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty() || ch!='*'){
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.reverse().toString();
    }
}