class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue((a, b) -> hashMap.get(b) - hashMap.get(a));
        maxHeap.addAll(hashMap.keySet());
        StringBuilder strBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Character ch = maxHeap.remove();
            for (int i = 0; i < hashMap.get(ch); i++) {
                strBuilder.append(ch);
            }
        }
        return strBuilder.toString();
    }
}