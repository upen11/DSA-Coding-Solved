class Solution {

    public int mySqrt(int x) {
        // 1 2 3 4 5 6 7 8
        // 9/2 = 4
        // 4*4 > 8
        // 4/2 = 2
        // 2*2 < 4
        // 3+4/2 = 3 < 2 condn failed

        if (x == 0 || x == 1) return x;

        long start = 1;
        long end = x;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid * mid == x) 
                return (int) mid; 
            else if (mid * mid < x) 
                start = mid + 1;
            else end = mid - 1;
        }

        return (int) end;
    }
}
