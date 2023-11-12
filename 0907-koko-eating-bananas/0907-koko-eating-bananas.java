class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1 ;
        for(int pile: piles){
            right = Math.max(right,pile);
        }
        while(left<right){
            int mid = (left + right) / 2 ;
            int hourSpend = 0;
            for(int pile: piles){
                hourSpend+=Math.ceil((double)pile/mid);
            }
            // if(hourSpend==h){
            //     return mid;
            // }
            if(hourSpend <= h){
                right = mid ;
            } else {
                left = mid+1;
            }
        }
        return right;
    }
}