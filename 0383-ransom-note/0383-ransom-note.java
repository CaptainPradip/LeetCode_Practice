class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            magazineMap.put(magazine.charAt(i),magazineMap.getOrDefault(magazine.charAt(i),0)+1);
        }
        for(int i=0;i < ransomNote.length();i++){
            char ch =ransomNote.charAt(i);
            if(magazineMap.containsKey(ch) && magazineMap.getOrDefault(ch,0) >=1){
                magazineMap.put(ch,magazineMap.getOrDefault(ch,0)-1);
                continue;
            }else{
                return false;
            }
            
        }
        return true;
    }
}