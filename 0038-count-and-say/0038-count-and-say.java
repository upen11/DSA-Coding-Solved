class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String ans = "1";
        for (int x = 2; x <= n; x++) {
            ans = count(ans);
        }

        return ans;
    }

    public String count(String num) {
        StringBuilder sb = new StringBuilder();

        int count = 1;

        int i = 0;
        for (i = 0; i < num.length() - 1; i++) {
            char ch = num.charAt(i);
            char ch1 = num.charAt(i + 1);

            if (ch == ch1) {
                count++;
            } else {
                sb.append(count);
                sb.append(ch);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(num.charAt(i)); // last character

        return sb.toString();
    }
}
