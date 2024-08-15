class Solution {
    public int numberOfAlternatingGroups(int[] s, int k) {
         int size = s.length;
        int start = 0, end = 1;
        int bad = 0; // count the trouble causing pairs in the window
        int res = 0;

        // why start < size ? every element can act 
        // as the start of the window.
        while(start < size){
            if(s[end % size] == s[(end - 1) % size]) bad++;
            if(end - start + 1 == k){
                if(bad == 0) res++;
                start++;

                // Subtract the effect of removed pair on bad count
                if(s[start % size] == s[(start - 1) % size]) bad--;   
            }
            end++;
        }
        return res;
    }
}