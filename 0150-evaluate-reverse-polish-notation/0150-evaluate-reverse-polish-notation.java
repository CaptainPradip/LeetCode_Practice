class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        for(String token : tokens){
            if(!"/+-*".contains(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }else {
                int b = stack.pop();
                int a = stack.pop();
                switch(token) {
                    case "+":
                        stack.push(a+b);
                        break;
                    
                    case "/":
                    int result = a / b ;
                        stack.push(result);
                        break;
                    
                    case "*":
                        stack.push(a*b);
                        break;
                    
                    case "-":
                        stack.push(a-b);
                        break;
                    
                }
            }
        }
        return stack.pop();
    }
}