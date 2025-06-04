class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // 1. create a stack with the index
        // 2. remove pop when temp is greater than the current
        // 3. add the result value with the poped index with previousDay;
        Stack<Integer> maxstack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i] ;
            while(!maxstack.isEmpty() && temperatures[maxstack.peek()] < currentTemp ){
                int preday = maxstack.pop() ;
                result[preday] =  i - preday;
            }
            maxstack.push(i);
        }
        return result;

    }
}