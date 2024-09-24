class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty() || stack.peek()!= ch){
                stack.push(ch);
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}