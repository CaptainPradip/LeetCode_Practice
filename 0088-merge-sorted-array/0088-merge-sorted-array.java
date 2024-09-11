class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int N = nums1.length - 1;
        while (N >= 0 && n > 0 && m > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[N] = nums2[n - 1];
                n--;
            } else {
                nums1[N] = nums1[m - 1];
                m--;
            }
            N--;
        }
        while (n - 1 >= 0) {
            nums1[N] = nums2[n - 1];
            N--;
            n--;
        }

    }
}