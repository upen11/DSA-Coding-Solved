class Solution {

    public int minFlipsMonoIncr(String s) {
        int one = 0;
        int zero = 0;
        int flip = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                if (one != 0) {
                    flip++;
                }
            }

            if (one < flip) {
                flip = one;
            }
        }

        return flip;
    }
}
