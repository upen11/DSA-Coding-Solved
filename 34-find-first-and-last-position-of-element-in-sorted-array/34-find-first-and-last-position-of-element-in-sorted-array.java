class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] arr = { -1, -1 };

        if (nums.length == 0) return arr;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                arr[0] = mid; // finding the first occurence
                end = mid - 1;
            }
        }

        start = 0;
        end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                arr[1] = mid; // finding the last occurence
                start = mid + 1;
            }
        }

        return arr;
    }
}
