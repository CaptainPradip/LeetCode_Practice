class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. Sort the Array O(nlog(n))
        // 2. Merge the array if the interval is in-between O(n)
        // Time Complexity O(nlog(n))
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}