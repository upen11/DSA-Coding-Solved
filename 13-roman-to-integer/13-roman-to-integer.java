class Solution {

    public int romanToInt(String s) {
        int num = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }

            if (i + 1 == s.length()) {
                sum += num;
                break;
            } else {
                char nextChar = s.charAt(i + 1);

                if (ch == 'I') if (nextChar == 'V') {
                    num = 4;
                    i++;
                } else if (nextChar == 'X') {
                    num = 9;
                    i++;
                }

                if (ch == 'X') if (nextChar == 'L') {
                    num = 40;
                    i++;
                } else if (nextChar == 'C') {
                    num = 90;
                    i++;
                }

                if (ch == 'C') if (nextChar == 'D') {
                    num = 400;
                    i++;
                } else if (nextChar == 'M') {
                    num = 900;
                    i++;
                }
            }
            sum += num;
        }

        return sum;
    }
}
