class Solution {

    public String intToRoman(int num) {
        int[] number = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] roman = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        StringBuilder sb = new StringBuilder();
        
        // starting from last of array number
        for (int i = number.length - 1; i >= 0; i--) {
            System.out.println(num);
            if (num > 0) {
                while (num >= number[i]) {
                    sb.append(roman[i]);
                    num -= number[i];
                }
            }
            else {
                break;
            }
        }
        
        return sb.toString();
    }
}
//  Another approach but takes more time
//         Map<Integer, String> map = new HashMap<>();
//         // String ans = "";
//         StringBuilder sb = new StringBuilder();
//         map.put(1, "I");
//         map.put(4, "IV");
//         map.put(5, "V");
//         map.put(9, "IX");
//         map.put(10, "X");
//         map.put(40, "XL");
//         map.put(50, "L");
//         map.put(90, "XC");
//         map.put(100, "C");
//         map.put(400, "CD");
//         map.put(500, "D");
//         map.put(900, "CM");
//         map.put(1000, "M");
//         //more than 1000 ? range in qus is 3999.
//         if (map.containsKey(num)) {
//             return map.get(num);
//         }
//         String val = String.valueOf(num);
//         int len = val.length();
//         for (int i = 0; i < len; i++) {
//             char ch = val.charAt(i);
//             int n = ch - '0';
//             int place = n * (int) Math.pow(10, len - i - 1);
//             System.out.println(place);
//             if (map.containsKey(place)) {
//                 sb.append(map.get(place));
//             } else {
//                 while (place != 0) {
//                     if (place >= 1000) {
//                         sb.append("M");
//                         place -= 1000;
//                     } else if (place >= 500 && place < 1000) {
//                         sb.append("D");
//                         place -= 500;
//                     } else if (place >= 100 && place < 500) {
//                         sb.append("C");
//                         place -= 100;
//                     } else if (place >= 50 && place < 100) {
//                         sb.append("L");
//                         place -= 50;
//                     } else if (place >= 10 && place < 50) {
//                         sb.append("X");
//                         place -= 10;
//                     } else if (place >= 5 && place < 10) {
//                         sb.append("V");
//                         place -= 5;
//                     } else if (place >= 1 && place < 5) {
//                         sb.append("I");
//                         place -= 1;
//                     }
//                 }
//             }
//         }
//         return sb.toString();
//     }
// }
