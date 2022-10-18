class Solution {

    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }

        int i, j = 0;
        for (i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);

            for (; j < t.length(); j++) {
                char chT = t.charAt(j);

                if (chS == chT) {
                    break;
                }
            }

            if (j++ == t.length()) 
                return false;
        }

        return (i == s.length()) ? true : false;
    }
}
//         int i=0;
//         int j=0;
//         int cnt=0;
//         if(s.length() > t.length())
//             return false;
//         while(i<s.length() && j<t.length()) {
//             if(s.charAt(i) == t.charAt(j)) {
//                 cnt++;
//                 i++;
//             }
//             j++;
//         }
//         if(s.length() == cnt)
//             return true;
//         else
//             return false;
//     }
// }
//        // 2nd approach
//        StringBuilder builder = new StringBuilder();
//         int jInc = 0;
//         for(int i=0; i<s.length(); i++) {
//             for(int j=jInc; j<t.length(); j++) {
//                 if(s.charAt(i) == t.charAt(j)){
//                     builder.append(t.charAt(j));
//                     jInc = ++j;
//                     if(jInc == t.length()){
//                         break;
//                     }
//                     break;
//                 }
//             }
//         }
//         // System.out.println("builder: "+builder);
//         // System.out.println("s: "+ s);
//         // System.out.println("t: "+ t);
//         // System.out.println(s.equals( builder.toString()));
//         if(s.equals(builder.toString()))
//             return true;
//         else
//             return false;
//     }
//}
