class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> s1Hashmap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Hashmap
                    .put(s1.charAt(i), s1Hashmap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2HashMap = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2HashMap.put(s2.charAt(i + j), s2HashMap.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            if (match(s1Hashmap, s2HashMap)) {
                return true;
            }

        }
        return false;
    }

    public boolean match(HashMap<Character, Integer> s1Hashmap, HashMap<Character, Integer> s2Hashmap) {

        for (char ch : s1Hashmap.keySet()) {
            if (s1Hashmap.get(ch) - s2Hashmap.getOrDefault(ch, -1) != 0) {
                return false;
            }
        }
        return true;

    }
}
