class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();

        int len = num.length - 1;
        int sum = 0;
        int carry = 0;
        while (len >= 0) {
            int d = 0;
            if (k > 0) {
                d = k % 10;
                k = k / 10;
            }

            sum = num[len--] + d + carry;
            carry = 0;
            if (sum > 9) {
                sum = (sum + carry) % 10;
                carry = 1;
            }
            list.add(sum);
        }

        while (k > 0) {
            sum = k % 10 + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            list.add(sum);
            k = k / 10;
        }

        if (carry != 0) {
            list.add(1);
        }

        Collections.reverse(list);

        return list;
    }
}
