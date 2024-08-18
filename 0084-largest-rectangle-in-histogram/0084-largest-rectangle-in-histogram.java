class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int tp;
        int toparea = 0;
        int i = 0;
        int n = heights.length;
        while (i < n) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                tp = stack.pop();
                toparea = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, toparea);
            }
        }
        while (!stack.isEmpty()) {
            tp = stack.pop();
            toparea = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, toparea);
        }
        return maxArea;
    }
}