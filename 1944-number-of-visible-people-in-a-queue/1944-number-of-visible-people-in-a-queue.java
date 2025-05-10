class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] ans = new int [n] ;
        for(int i = n - 1; i >=0; i--){
            while(!stack.empty() && heights[i]> stack.peek()){
                stack.pop();
                ++ans[i];
            }
            if(!stack.empty()){
                ++ans[i] ;
            }
            stack.push(heights[i]);
        }
        return ans;
    }
}