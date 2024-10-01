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
        // 1. sort the given interval
        // Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        LinkedList<int[]> merge = new LinkedList<>();
        for (int[] interval : intervals) {
            // check the interval is overlap or not
            if (merge.isEmpty() || merge.getLast()[1] < interval[0]) {
                // not overlap so just add then interval
                merge.add(interval);
            } else {
                // its overlap so update the end point
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);

    }
}