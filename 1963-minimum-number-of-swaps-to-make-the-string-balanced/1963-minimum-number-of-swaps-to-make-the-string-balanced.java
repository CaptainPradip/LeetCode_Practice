class Solution {
    public int minSwaps(String s) {
        int mismatch = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                mismatch++;
            }else {
                if(mismatch>0){
                    mismatch--;
                }
            }
        }
        return (mismatch+1)/2;

    }
}