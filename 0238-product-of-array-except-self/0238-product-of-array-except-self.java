class Solution {

    public int[] productExceptSelf(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int[] output = new int[arr.length];

        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
            left[i] = product;
        }

        product = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            product *= arr[i];
            right[i] = product;
        }

        output[0] = right[1];
        output[arr.length - 1] = left[arr.length - 2];

        for (int i = 1; i < arr.length - 1; i++) {
            output[i] = left[i - 1] * right[i + 1];
        }

        return output;
    }
}
