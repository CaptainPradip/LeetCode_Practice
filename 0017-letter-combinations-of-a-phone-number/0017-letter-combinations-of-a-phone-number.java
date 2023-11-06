class Solution {

    private List<String> combinations = new ArrayList<>();
    private Map<Character,String> letters = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return combinations;
        }
        phoneDigits=digits;
        backTrack(0,new StringBuilder());
        return combinations;
    }
    private void backTrack(int index,StringBuilder path){
        if(path.length()==phoneDigits.length()){
            combinations.add(path.toString());
            return;
        }
        String posssibleLetters = letters.get(phoneDigits.charAt(index));
        for(char letter:posssibleLetters.toCharArray()){
            path.append(letter);
            backTrack(index+1,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}