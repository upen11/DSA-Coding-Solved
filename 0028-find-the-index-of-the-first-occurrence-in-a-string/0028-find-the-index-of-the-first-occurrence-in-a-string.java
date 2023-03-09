class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int count = 0;
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i;
                for (char m : needle.toCharArray()) {
                    if (m == haystack.charAt(j++)) {
                        count++;
                    } else {
                        break;
                    }

                    if (count == needle.length()) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
