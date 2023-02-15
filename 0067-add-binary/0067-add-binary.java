class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        if (a.length() < b.length()) return addBinary(b, a);

        int l = a.length() - 1;
        int m = b.length() - 1;
        int carry = 0;
        int sum = 0;
        // traversing bigger String
        while (l >= 0) {
            int x = a.charAt(l--) - '0';

            int y = 0;
            if (m >= 0) {
                y = b.charAt(m--) - '0';
            }

            sum = x + y + carry;
            
            if (sum == 0 || sum == 1) {
                carry = 0;
            } else if (sum == 2) {
                sum = 0;
                carry = 1;
            } else if (sum == 3) {
                sum = 1;
                carry = 1;
            }

            sb.append(String.valueOf(sum));
        }
        
        // important
        if(carry == 1) sb.append("1");

        return sb.reverse().toString();
    }
}
