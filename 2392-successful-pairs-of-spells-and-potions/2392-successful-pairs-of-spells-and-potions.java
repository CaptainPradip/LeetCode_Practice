class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //Arrays.sort(spells);
        Arrays.sort(potions);
        int[] result = new int [spells.length];
        int index = 0;
        int m = potions.length;
        int maxPotion = potions[m - 1];
        for(int spell : spells ){
            long minPotion = (long) Math.ceil((1.0 * success) / spell);
            int left = 0;
            int right = potions.length;
            if (minPotion > maxPotion) {
                result[index++] = 0;
                continue;
            }
            // Binary Search 
            while(left < right){
                int mid = left+(right-left)/2;
                if((int) minPotion > potions[mid]){
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            result[index++]= potions.length-left;

        }
       
        return result;
    }
}