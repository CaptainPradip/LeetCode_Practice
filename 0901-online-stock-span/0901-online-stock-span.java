class StockSpanner {
    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int ans = 1;
        Stack<int[]> stack2 = stack;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }
        stack.push(new int[] { price, ans });
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */