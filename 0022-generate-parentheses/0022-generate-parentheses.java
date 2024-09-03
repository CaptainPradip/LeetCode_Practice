class Solution {
    List<String> result = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        // 1. 2 pair is (()) that means the max we can make it 2*n
        // 2. base case is until length == 2*n
        // 3. and opening bracket will be less than n
        // 4. and closing bracket will be less than opening size
        this.n = n;
        backTracking(0, 0, "");
        return result;

    }

    public void backTracking(int open, int close, String str) {
        if (str.length() == 2 * this.n) {
            result.add(str);
        }
        if (open < n) {
            backTracking(open + 1, close, str + "(");
        }
        if (close < open) {
            backTracking(open, close + 1, str + ")");
        }
    }
}