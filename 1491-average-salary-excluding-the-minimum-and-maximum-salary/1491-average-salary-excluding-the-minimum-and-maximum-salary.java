class Solution {

    public double average(int[] salary) {
        int n = salary.length - 2;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : salary) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        double sumWithoutMaxAndMin = sum - (max + min);

        return sumWithoutMaxAndMin / n;
    }
}
