class Solution {
    // n log n
    public String customSortStringNlogN(String order, String s) {

        int n = s.length();
        Character[] sArr = new Character[n];
        for (int i = 0; i < n; i++) {
            sArr[i] = s.charAt(i);
        }
        Arrays.sort(sArr, (a, b) -> {
            return order.indexOf(a) - order.indexOf(b);
        });
        String str = "";
        for (int i = 0; i < n; i++) {
            str += sArr[i];
        }
        return str;
    }

    // O(n); using extra space
    public String customSortString(String order, String s) {

        int n = s.length();
        HashMap<Character, Integer> frequency = new HashMap<>();
        Character[] sArr = new Character[n];
        // Make Frequency Map;
        for (int i = 0; i < n; i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        String result = "";
        for (char ch : order.toCharArray()) {
            int fr = frequency.getOrDefault(ch, 0);
            for (int i = 0; i < fr; i++) {
                result += ch;
            }
            frequency.remove(ch);
        }
        for (char ch : frequency.keySet()) {
            int fr = frequency.get(ch);
            for (int i = 0; i < fr; i++) {
                result += ch;
            }
        }
        return result;

    }
}