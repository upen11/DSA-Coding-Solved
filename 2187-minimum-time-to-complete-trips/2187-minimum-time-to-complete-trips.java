class Solution {

    public long minimumTime(int[] time, int totalTrips) {
        long min = Integer.MAX_VALUE;
        for (int i : time) {
            min = Math.min(i, min);
        }

        long start = 1;
        long end = min * totalTrips; // worst can be min * totalTrips

        while (start < end) {
            long mid = start + (end - start) / 2;
            long trips = 0;
            for (int t : time) {
                trips += (mid / t);
            }

            if (trips < totalTrips) {
                start = mid + 1;
            } else {
                end = mid; // we are including mid cause >=
            }
        }

        return start;   // answer will be start cause when (start >= end) loop will exit
    }
    // not working
    /*
        int i = 1;
        int trips = 0;
        boolean flag = false;
        while (trips != totalTrips) {
            trips = 0;
            for (int t : time) {
                trips += (i / t) % 1_000_000_007;

                if (trips == totalTrips) {
                    flag = true;
                    break;
                }
            }

            if (flag == true) {
                break;
            }
            i++;
        }

        return i;
    }
    */
}
