class Solution {
    public int largestRectangleArea(int[] heights) {
        
    Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int tp;
		int toparea = 0;
		int i = 0;
      //6
        //
       //1,2,3
		while (i < heights.length) {
			if (stack.empty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i++);
			} else {
				tp = stack.peek();
				stack.pop();
				toparea = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);
				if (toparea > maxArea) {
					maxArea = toparea;
				}
			}
		}
		while (stack.empty() == false) {
			tp = stack.peek();
			stack.pop();
			toparea = heights[tp] * (stack.empty() ? i : i - stack.peek() - 1);
			if (toparea > maxArea) {
				maxArea = toparea;
			}
		}
		return maxArea;
    }
}