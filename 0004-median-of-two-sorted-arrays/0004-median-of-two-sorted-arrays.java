class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        // finding smaller array.. to do binary search
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        double median = 0.0;

        int len = nums1.length + nums2.length;

        int start = 0;
        int end = nums1.length;
        int mid = 0;
        int l2 = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            l2 = (len + 1) / 2 - mid;

            int left1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            int l1mid = mid == nums1.length ? Integer.MAX_VALUE : nums1[mid];
            int left2 = l2 == 0 ? Integer.MIN_VALUE : nums2[l2 - 1];
            int l2mid = l2 == nums2.length ? Integer.MAX_VALUE : nums2[l2];

            if (left1 <= l2mid && left2 <= l1mid) {
                if (len % 2 == 0) {
                    median = (Math.max(left1, left2) + Math.min(l1mid, l2mid)) / 2.0;
                } else {
                    median = Math.max(left1, left2);
                }

                return median;
            } else if (l1mid > left2) {
                // there are more elements to be picked in left part of 'nums2' arrray
                end = mid - 1;
            } else if (left2 > l1mid) {
                // there are more elements to be picked in left part of 'nums1' arrray
                start = mid + 1;
            }
        }

        return 0.0;
    }
}
