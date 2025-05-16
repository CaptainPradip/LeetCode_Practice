class Solution {
    // 1. first count the numbers of characters frequency
    // 2. use sliding window add the char to the map to keep the count
    // 3. if u find the exact count u need to then move left pointer and reduce
    // the window
    // 4. create the array with with the length and start index and end index

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> frequencyCountT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            frequencyCountT.put(t.charAt(i),
                    frequencyCountT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int requiredCharCount = frequencyCountT.size();
        int left = 0;
        int right = 0;
        int currentCharCount = 0;
        Map<Character, Integer> windowCharFrequncy = new HashMap<>();
        int[] ans = { -1, 0, 0 };
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCharFrequncy.put(rightChar,
                    windowCharFrequncy.getOrDefault(rightChar, 0) + 1);
            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (frequencyCountT.containsKey(rightChar) && windowCharFrequncy
                    .get(rightChar)
                    .intValue() == frequencyCountT.get(rightChar).intValue()) {
                currentCharCount++;
            }
            // Try and contract the window till the point where it ceases to be
            // 'desirable'.
            while (left <= right && requiredCharCount == currentCharCount) {
                char leftChar = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCharFrequncy.put(leftChar,
                        windowCharFrequncy.get(leftChar) - 1);
                if (frequencyCountT.containsKey(leftChar) && windowCharFrequncy
                        .get(leftChar).intValue() < frequencyCountT
                                .get(leftChar).intValue()) {
                    currentCharCount--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);

    }
}