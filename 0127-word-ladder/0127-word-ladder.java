class Solution {
    public int ladderLength(String source, String target, List<String> words) {
        if (source.length() != target.length()) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordsSet = new HashSet<>(words);
        int length = 1;
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentString = queue.remove();
                if (currentString.equals(target)) {
                    return length;
                }
                for (int j = 0; j < currentString.length(); j++) {
                    char[] currentStringArr = currentString.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currentStringArr[j] = ch;
                        String newString = new String(currentStringArr);
                        if (wordsSet.contains(newString) && !visited.contains(newString)) {
                            queue.add(newString);
                            visited.add(newString);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}