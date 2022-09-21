class Solution {

    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = 46340;   //sq root of 2^31. This is the max a number can be.
        int mid = 0;
        boolean found = false;
        while (start <= end) {
            mid = start + (end - start) / 2;
          
            if (mid * mid == num) {
                found = true;
                break;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return found;
    }
}
