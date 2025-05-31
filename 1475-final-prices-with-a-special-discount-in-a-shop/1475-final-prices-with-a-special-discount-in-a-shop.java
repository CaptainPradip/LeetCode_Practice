class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> minstack = new Stack<>();
        int i = 0;
        int n= prices.length;
        int [] result = prices.clone();
        while(i < n){
            if(!minstack.isEmpty() && prices[minstack.peek()] >= prices[i]){
               int index = minstack.pop();
               result[index] = prices[index]-prices[i];
               continue;
            } else {
                minstack.push(i);
            }
            i++;
        }
        return result;
    }
}