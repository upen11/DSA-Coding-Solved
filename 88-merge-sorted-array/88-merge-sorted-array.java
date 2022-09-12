class Solution {

    // [0,0,3,0,0,0,0,0,0]
    // 3
    // [-1,1,1,1,2,3]
    // 6
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1;
        int l2 = n - 1;
        int len = m + n - 1;
        while (l2 != -1) {
            if (m == 1 && n == 0) {
                System.out.print(nums1[0]);
                break;
            }

            if (m == 0 && n == 1) {
                nums1[0] = nums2[0];
                System.out.print(nums1[0]);
                break;
            }

            if ((l1 == -1) || (nums2[l2] >= nums1[l1])) {
                nums1[len] = nums2[l2];
                l2--;
            } else if (nums2[l2] < nums1[l1]) {
                nums1[len] = nums1[l1];
                l1--;
            }
            len--;
        }
    }
}
