class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> result = new LinkedList<>();
        HashMap<Character, Integer> pHashMap = new HashMap<>();
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        int pLength = p.length();
        int sLength = s.length();
        if (pLength > sLength) {
            return result;
        }
        for (int i = 0; i < pLength; i++) {
            pHashMap.put(p.charAt(i), pHashMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < sLength; i++) {
            sHashMap.put(s.charAt(i), sHashMap.getOrDefault(s.charAt(i), 0) + 1);
            if (i >= pLength) {
                char ch = s.charAt(i - pLength);
                if (sHashMap.get(ch) == 1) {
                    sHashMap.remove(ch);
                } else {
                    sHashMap.put(ch, sHashMap.get(ch) - 1);
                }

            }
            if (sHashMap.equals(pHashMap)) {
                result.push(i - pLength + 1);
            }
        }
        return result;
    }
}