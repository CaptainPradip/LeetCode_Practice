class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i;
        int n = citations.length;
        for (i = 1; i <= n; i++) {
            if (citations[n - i] < i) {
                break;
            }
        }
        return i - 1;
    }
}