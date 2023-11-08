class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> mapWord1 = new HashMap<>();
        HashMap<Character, Integer> mapWord2 = new HashMap<>();
        if(word1.length()!=word2.length()){
            return false;
        }
        for(int i=0;i< word1.length() ;i++){
            mapWord1.put(word1.charAt(i),mapWord1.getOrDefault(word1.charAt(i),0)+1);
            mapWord2.put(word2.charAt(i),mapWord2.getOrDefault(word2.charAt(i),0)+1);
        }
        if (!mapWord1.keySet().equals(mapWord2.keySet())) {
            return false;
        }
        List<Integer> frequecyCounts1 = new ArrayList(mapWord1.values()) ;
        Collections.sort(frequecyCounts1);
        List<Integer> frequecyCounts2 = new ArrayList(mapWord2.values()) ;
        Collections.sort(frequecyCounts2);
        return frequecyCounts1.equals(frequecyCounts2);

    }
}