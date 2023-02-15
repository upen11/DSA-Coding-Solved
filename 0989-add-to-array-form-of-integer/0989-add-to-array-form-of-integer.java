class Solution {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();

        int len = num.length - 1;
        int sum = 0;
        while ((len >= 0) || (k > 0)) {
            if (len >= 0) {
                k = num[len--] + k;
            }
            sum = k % 10;
            list.add(sum);
            k = k / 10;
        }

        Collections.reverse(list);

        return list;
    }
}
