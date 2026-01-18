class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int left = m - 1;
        int right = n - 1;

        for (int k = m + n - 1; k >= 0; k--) {
            if (left < 0) {
                nums1[k] = nums2[right];
                right--;
            } else if (right < 0) {
                break;
            } else if (nums1[left] > nums2[right]) {
                nums1[k] = nums1[left];
                left--;
            } else {
                nums1[k] = nums2[right];
                right--;
            }
        }
    }
}