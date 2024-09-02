class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] currArray = currWord.toCharArray();
                for (int j = 0; j < currArray.length; j++) {
                    char originalChar = currArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currArray[j] = c;
                        String newWord = new String(currArray);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(newWord)) {
                            set.remove(newWord);
                            queue.add(newWord);
                        }
                    }
                    currArray[j] = originalChar;
                }
            }
            level++;
        }
        return 0;
    }
}