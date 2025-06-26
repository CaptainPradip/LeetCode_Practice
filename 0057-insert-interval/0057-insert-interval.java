class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> merged = new LinkedList<int[]>();
        boolean isInserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                merged.add(i, newInterval);
                isInserted = true;
            }
            merged.add(intervals[i]);
        }
        if (!isInserted) {
            merged.add(newInterval);
        }
        return merge(merged.toArray(new int[merged.size()][]));

    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merge = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merge.isEmpty() || merge.getLast()[1] < interval[0]) {
                merge.add(interval);
            } else {
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}