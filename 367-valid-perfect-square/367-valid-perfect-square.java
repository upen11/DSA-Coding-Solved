class Solution {

    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        long mid = 0;
        boolean found = false;
        while (start <= end) {
            mid = start + (end - start) / 2;
          
            if (mid * mid == num) {
                found = true;
                break;
            } else if (mid * mid < num) {
                start = (int)mid + 1;
            } else {
                end = (int)mid - 1;
            }
        }

        return found;
    }
}
