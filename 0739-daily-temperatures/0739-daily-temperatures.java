class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // 1. create a stack with the index
        // 2. remove pop when temp is greater than the current
        // 3. add the result value with the poped index with previousDay;
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                result[prevDay] = i - prevDay;
            }
            stack.push(i);
        }
        return result;

    }
}