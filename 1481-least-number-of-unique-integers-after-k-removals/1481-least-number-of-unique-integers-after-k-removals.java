class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.addAll(map.values());
        int removeElement = 0;
        while (!minHeap.isEmpty()) {
            removeElement += minHeap.peek();
            if (removeElement > k) {
                return minHeap.size();
            }
            minHeap.remove();
        }
        return 0;

    }
}