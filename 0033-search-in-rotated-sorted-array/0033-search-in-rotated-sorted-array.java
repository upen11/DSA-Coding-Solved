class Solution {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int minInd = findMin(nums);
        
        System.out.println(minInd);

        int start = 0;
        int end = nums.length - 1;

        if (minInd == 0) {
            // continue;
        } else if (target >= nums[0] && target <= nums[minInd - 1]) {
            end = minInd - 1;
        } else if (target >= nums[minInd] && nums[minInd] <= nums[end]) {
            start = minInd;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) return mid; else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if (nums[start] <= nums[end]) return start;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) return mid + 1;

            if (nums[mid - 1] > nums[mid]) return mid;

            if (nums[0] <= nums[mid]) {
                // means this part is sorted
                start = mid + 1;
            } else if (nums[0] > nums[mid]) {
                // means this part is not sorted and mau contain minimum
                end = mid;
            }
        }

        return -1;
    }
}
