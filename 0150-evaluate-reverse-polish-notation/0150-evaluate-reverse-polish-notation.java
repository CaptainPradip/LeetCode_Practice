class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a+b));
            }
            else if(s.equals("-")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b - a));
            }
            else if(s.equals("*")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a*b));
            }
            else if(s.equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b/a));
            }
            else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}