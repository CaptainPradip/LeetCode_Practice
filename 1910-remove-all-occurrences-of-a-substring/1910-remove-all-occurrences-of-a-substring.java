class Solution {
    public String removeOccurrences(String s, String part) {
        if (s.contains(part)) {
             String replaceString = s.replaceFirst(part, "");
            return removeOccurrences(replaceString, part);
        } 
        return s;

    }
}