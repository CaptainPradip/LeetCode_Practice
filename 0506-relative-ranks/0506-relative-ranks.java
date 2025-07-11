class Solution {
    public String[] findRelativeRanks(int[] score) {
        int totalRank = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> score[b] - score[a]);

        for (int j = 0; j < score.length; j++) {
            maxHeap.add(j);
        }
        String[] result = new String[score.length];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int index = maxHeap.poll();
            if (i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else if (i > 2) {
                int rank = i + 1;
                result[index] = "" + rank;
            }
            i++;
        }
        return result;
    }
}