class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n );
        return result;
    }

    public void backtrack(List<String> output, String currentString, int open,int close,int max ){
        if(currentString.length()==max*2){
            output.add(currentString);
            return;
        }
        if(open < max){
            backtrack(output,currentString+"(",open+1,close,max);
        }
        if(close < open){
            backtrack(output,currentString+")", open,close+1,max);
        }
    }
}