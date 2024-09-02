class Solution {
    public int[][] kClosest(int[][] points, int k) {

        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

        for (int i = 0; i < points.length; i++) {
            minHeap.add(points[i]);
        }

        while (k > 0) {
            result.add(minHeap.poll());
            k--;
        }
        return result.toArray(new int[result.size()][]);
    }

}