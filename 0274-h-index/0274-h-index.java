class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n= citations.length,i;
        for(i=1; i<=n;i++){
            if(citations[n-i]<i){
                break;
            }

        }return i-1;

    }
}