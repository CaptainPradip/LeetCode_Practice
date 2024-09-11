class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;

        int j = 0;
        while (j < arr.length) {
            if (arr[j] == i + 1) {
                j++;
                i++;
            } else {
                i++;
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        while (k > 0) {
            i++;
            k--;
        }
        return i ;
    }
}