class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 1. add the number priority q
        // check peek - x abs value is less than the num -x abs then dont add if both
        // same then add
        // Create a max heap by sorting in descending order if both are same then
        // consider the index
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[2] - a[2] : b[0] - a[0]);
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new int[] { Math.abs(arr[i] - x), arr[i], i });
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Use poll() to remove the maximum element
            }
        }
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]); // Use poll() to retrieve and remove the maximum element
        }

        Collections.sort(result);
        return result;
    }
}