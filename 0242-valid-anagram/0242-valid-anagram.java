class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (frequency.containsKey(t.charAt(i)) && frequency.get(t.charAt(i)) > 0) {
                frequency.put(t.charAt(i), frequency.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;

    }
}

// Input: s = "anagram", t = "nagaram"
// Output: true

// 1. sort both strign then check equal or not // n log(n)
// HashMap