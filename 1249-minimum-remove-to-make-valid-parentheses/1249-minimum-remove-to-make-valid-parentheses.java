class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int i = 0 ;
        while(i<n){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.add(i);
            } else if(ch==')'){
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                } else {
                    stack.add(i);
                }
            }
            i++;
        }
        while(!stack.isEmpty()){
            removeIndex.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(i=0; i<s.length();i++){
            if(!removeIndex.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}