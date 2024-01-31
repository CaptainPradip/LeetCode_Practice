class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
				(a, b) -> hashMap.get(a) - hashMap.get(b));

		int[] result = new int[k];
		for (int key : hashMap.keySet()) {
			minHeap.add(key);
			if (minHeap.size() > k) {
				minHeap.remove();
			}
		}
		for(int i=0; i< k ;i++) {
			result[i]= minHeap.remove();
		}
		return result;
    }
}