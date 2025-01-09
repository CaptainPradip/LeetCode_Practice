class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;

    }

    public int searchInsert1(int[] nums, int target) {
        // Define left and right bounds
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Calculate the middle of the current search space
            int mid = left + (right - left) / 2;
            // If middle element is the target, return mid index
            if (nums[mid] == target) {
                return mid;
            }
            // If mid is too large, discard larger half
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // If mid is too small, discard smaller half
                left = mid + 1;
            }
        }
        // if the target is not found, the left index would be position
        // where it would be if it were inserted in order.
        return left;
    }
}