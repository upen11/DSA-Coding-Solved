class Solution {

    // using HashMap
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // if only one element is there eg. "D"
        if(s.length() == 1) {
            return map.get(s.charAt(0));
        }

        int num = 0;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i - 1);
            char ch2 = s.charAt(i);

            if (map.get(ch) < map.get(ch2)) {
                num += (map.get(ch2) - map.get(ch));
                i++;
            } else {
                num += map.get(ch);
            }
        }

        // above for loop will not add the last character if the second last is >= to it. eg. "CMVI" or "III"
        if (map.get(s.charAt(s.length() - 2)) >= map.get(s.charAt(s.length() - 1))) {
            num += map.get(s.charAt(s.length() - 1));
        }

        return num;
    }
}
// 2nd Approach
//         int num = 0;
//         int sum = 0;
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             switch (ch) {
//                 case 'I':
//                     num = 1;
//                     break;
//                 case 'V':
//                     num = 5;
//                     break;
//                 case 'X':
//                     num = 10;
//                     break;
//                 case 'L':
//                     num = 50;
//                     break;
//                 case 'C':
//                     num = 100;
//                     break;
//                 case 'D':
//                     num = 500;
//                     break;
//                 case 'M':
//                     num = 1000;
//                     break;
//             }
//             if (i + 1 == s.length()) {
//                 sum += num;
//                 break;
//             } else {
//                 char nextChar = s.charAt(i + 1);
//                 if (ch == 'I') if (nextChar == 'V') {
//                     num = 4;
//                     i++;
//                 } else if (nextChar == 'X') {
//                     num = 9;
//                     i++;
//                 }
//                 if (ch == 'X') if (nextChar == 'L') {
//                     num = 40;
//                     i++;
//                 } else if (nextChar == 'C') {
//                     num = 90;
//                     i++;
//                 }
//                 if (ch == 'C') if (nextChar == 'D') {
//                     num = 400;
//                     i++;
//                 } else if (nextChar == 'M') {
//                     num = 900;
//                     i++;
//                 }
//             }
//             sum += num;
//         }
//         return sum;
//     }
// }
