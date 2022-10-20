/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        int peak = peak(mountainArr, start, end);
        int idx1 = searchFirstHalf(mountainArr, target, start, peak);
        if (idx1 != -1) return idx1;

        int idx2 = searchSecondHalf(mountainArr, target, peak, end);
        return idx2;
    }

    public static int peak(MountainArray mountainArr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int midVal = mountainArr.get(mid);

            if (start == end) {
                break;
            } else if (midVal < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start == end) return start;

        return -1;
    }

    public static int searchFirstHalf(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int searchSecondHalf(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            } else if (midVal > target) { // for descending just change < to >
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
