class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> monotonicStack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!monotonicStack.isEmpty() && heights[monotonicStack.peek()] <= heights[i]) {
                monotonicStack.pop();
            }
            monotonicStack.push(i);
        }
        int [] ans = new int [monotonicStack.size()];
        for(int i = monotonicStack.size()-1; i>=0 ;i--){
            ans[i] = monotonicStack.pop();
        }

        return ans;

    }
}