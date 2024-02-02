class Solution {
    public boolean rotateString(String s, String goal) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(0)) {
                str = str + s.charAt(i);
            } else {
                String temp = s.substring(i , s.length()) + str;
                if (temp.equals(goal)) {
                    return true;
                }
                str = str + s.charAt(i);
            }
        }

        return false;
    }
}