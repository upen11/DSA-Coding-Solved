class Solution {

    
    
    public int[] productExceptSelf(int[] arr) {
        int[] output = new int[arr.length];

        // first output stores the left product of array expect the ith element
        output[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            output[i] = arr[i - 1] * output[i - 1];
        }

        // we move from right and with the help of rightProduct and output arr(which stores left arr product) find the output
        int rightProduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            output[i] = output[i] * rightProduct;
            rightProduct *= arr[i];
        }

        return output;
    }
    
    /*
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
    */
}
