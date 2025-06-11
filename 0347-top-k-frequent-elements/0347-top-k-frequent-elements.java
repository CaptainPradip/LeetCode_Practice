class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Create HashMap with frequency
        // 2. Create minheap size k as it will keep only k element
        // 3. create the result array
        // Time Complexity n logn
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequency.get(a) - frequency.get(b));

        for (int n : frequency.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.remove();
        }
        return result;
    }
}