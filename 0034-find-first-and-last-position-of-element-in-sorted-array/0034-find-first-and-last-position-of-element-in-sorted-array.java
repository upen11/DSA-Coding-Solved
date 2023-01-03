class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[] { -1, -1 };

        if (nums.length == 0) return arr;

        arr[0] = findingFirstOccurence(nums, target);
        arr[1] = findingLastOccurence(nums, target);

        return arr;
    }

    public int findingFirstOccurence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int beg = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                beg = mid;
                end = mid - 1; // because nothing after mid can be the first occurance of target
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return beg;
    }

    public int findingLastOccurence(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int last = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                last = mid;
                start = mid + 1; // because nothing before mid can be the last occurance of target
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return last;
    }
}
