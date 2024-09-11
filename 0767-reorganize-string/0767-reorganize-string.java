class Solution {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                heap.add(new int[] { i + 'a', charCount[i] });
            }
        }
        String result = "";
        while (!heap.isEmpty()) {
            int[] first = heap.remove();
            if (result.length() == 0 || first[0] != result.charAt(result.length() - 1)) {
                result += (char) first[0];
                if (--first[1] > 0) {
                    heap.add(first);
                }
            } else {
                if (heap.isEmpty()) {
                    return "";
                }
                int[] second = heap.remove();
                result += (char) second[0];
                if (--second[1] > 0) {
                    heap.add(second);
                }
                heap.add(first);
            }
        }

        return result;
    }
}