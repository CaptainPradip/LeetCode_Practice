class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();
        backTrack(s,0,0,result,"");
        return result;
        // 1. divide string int0 4 part
        //
    }

    public void backTrack(String s, int currentIndex, int part, List<String> result, String str) {

        // Valid
        if (currentIndex == s.length() || part == 4) {
            if (currentIndex == s.length() && part == 4) {
                result.add(str.substring(0, str.length() - 1));
            }
            return;
        }
        backTrack(s, currentIndex + 1, part + 1, result, str + s.charAt(currentIndex) + ".");
        if (currentIndex + 2 <= s.length() && isValid(s.substring(currentIndex, currentIndex + 2))) {
            backTrack(s, currentIndex + 2, part + 1, result, str + s.substring(currentIndex, currentIndex + 2) + ".");
        }
        if (currentIndex + 3 <= s.length() && isValid(s.substring(currentIndex, currentIndex + 3))) {
            backTrack(s, currentIndex + 3, part + 1, result, str + s.substring(currentIndex, currentIndex + 3) + ".");
        }
    }
      boolean isValid(String num) {
        if(num.charAt(0) == '0') return false;
        return Integer.parseInt(num) <= 255;
    }

}