class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));
        for (int key : hashMap.keySet()) {
            minHeap.add(key);
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