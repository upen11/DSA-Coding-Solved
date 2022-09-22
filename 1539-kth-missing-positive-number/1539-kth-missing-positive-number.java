class Solution {

    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int numOfMissNums = arr[mid] - (mid + 1); // value subtracts index + 1 to get the missing numbs
            if (numOfMissNums < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start + k;
    }
}
