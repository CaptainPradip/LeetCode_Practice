class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int[] end = points[0];
        int count = 1;
        // [[1,6],[2,8],[7,12],[10,16],]
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end[1]) {
                count++;
                end = points[i];
            }
        }
        return count;
    }
}