class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        // 1. Sort the array with the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // check for end with the start with second
        // if( first end is more than the second start that mean it will merge)
        // else add the second interval
        for (int[] interval : intervals) {

            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else {
                int[] merge = new int[] { Math.min(result.getLast()[0], interval[0]),
                        Math.max(result.getLast()[1], interval[1]) };
                result.getLast()[1] =  Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}