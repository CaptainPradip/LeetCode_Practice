class Solution {
 public int longestValidSubstring(String word, List<String> forbidden) {
		Set<String> set = new HashSet<>(forbidden);

		int maxLen = 0;
		for (String f : forbidden)
			maxLen = Math.max(maxLen, f.length());

		int end = word.length();
		int longest = 0;
		word = word.toLowerCase();
		for (int i = word.length() - 1; i >= 0; i--) {
			for (int j = i + 1; j <= end && j - i <= maxLen; j++) {
				String sub = word.substring(i, j);
				if (set.contains(sub)) {
					end = j - 1;
					break;
				}
			}
			longest = Math.max(longest, end - i);
		}

		return longest;
	}
}