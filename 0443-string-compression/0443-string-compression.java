class Solution {

    public int compress(char[] chars) {
        // traverse the array
        // pick the character and count it
        // then I will update in the new array

        if (chars.length == 1) return 1;

        int count = 1;
        int j = 1;
        char lastCh = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastCh) {
                count++;
            } else {
                if (count > 1) {
                    String countInStr = String.valueOf(count);
                    for (int k = 0; k < countInStr.length(); k++) {
                        chars[j++] = countInStr.charAt(k);
                    }
                }
                count = 1;
                lastCh = chars[i];
                chars[j++] = chars[i];
            }
        }

        if (count > 1) {
            String countInStr = String.valueOf(count);
            for (int k = 0; k < countInStr.length(); k++) {
                chars[j++] = countInStr.charAt(k);
            }
        }

        return j;
    }
    /*
        List<String> list = new ArrayList<>();

        list.add(chars[0] + "");
        char ch = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (ch == chars[i]) {
                count++;
            } else {
                if (count == 1) {
                    //skip
                } else if (count < 9) {
                    list.add(count + "");
                } else {
                    String cinS = String.valueOf(count);

                    for (int j = 0; j < cinS.length(); j++) {
                        list.add(cinS.charAt(j) + "");
                    }
                }
                ch = chars[i];
                list.add(ch + "");
                count = 1;
            }
        }

        if (ch == chars[chars.length - 1]) {
            if (count == 1) {
                // skip
            } 
            else if (count > 9) {
                String cinS = String.valueOf(count);

                for (int j = 0; j < cinS.length(); j++) {
                    list.add(cinS.charAt(j) + "");
                }
            } else {
                list.add(count + "");
            }
        }

        // System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i).charAt(0);
        }

        return list.size();
    }
    */

}
