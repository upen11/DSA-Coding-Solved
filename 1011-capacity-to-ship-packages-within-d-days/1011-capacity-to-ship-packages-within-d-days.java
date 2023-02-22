class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;

        for (int i : weights) {
            max = Math.max(max, i);
            sum += i;
        }

        int low = max;
        int high = sum;

        boolean isValid = false;

        while (low < high) {
            int cap = low + (high - low) / 2;

            isValid = valid(weights, days, cap);
            // System.out.println("cap : "+cap);
            // System.out.println("isValid : "+isValid);

            if (isValid) {
                high = cap;
            } else {
                low = cap + 1;
            }
        }

        return low;
    }

    public boolean valid(int[] weights, int days, int cap) {
        int countDays = 1;
        int sum = 0;

        for (int i : weights) {
             sum += i;
            
            if (sum > cap) {
                countDays++;
                sum = i;
            }
            
            if(countDays > days) {
                break;
            }

        }

        return countDays <= days;
    }
}
