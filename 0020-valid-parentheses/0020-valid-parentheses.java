class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){

            if(ch=='('|| ch =='{' || ch=='['){
                stack.push(ch);
            } else {
                if(!stack.isEmpty()){
                    char top = stack.peek();
                    if((top == '(' && ch==')' ) || (top =='[' && ch==']') || (top =='{' && ch=='}')){
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }else {
                     stack.push(ch);
                }
                
            }
        }
        return stack.size()==0;
    }
}