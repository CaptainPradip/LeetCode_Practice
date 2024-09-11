class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Create HashMap with frequency
        // 2. Create minheap size k as it will keep only k element
        // 3. create the result array
        // Time Complexity n logn
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> hashMap.get(a) - hashMap.get(b));
        for (int key : hashMap.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.remove();
        }
        return result;

    }
}