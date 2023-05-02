class Solution {

    public int arraySign(int[] nums) {
        long product = 1;
        for (int i : nums) {
            if (i == 0) return 0;

            i = i > 0 ? 1 : -1;
            product *= i;
        }

        //         System.out.println(product);

        return product > 0 ? 1 : -1;
    }
}
