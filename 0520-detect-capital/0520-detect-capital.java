class Solution {

    public boolean detectCapitalUse(String word) {
        int allCap = 0, allSmall = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (isCapital(ch)) {
                allCap++;
            } else {
                allSmall++;
            }
        }

        if (allSmall == word.length() || allCap == word.length()) return true;

        if ((isCapital(word.charAt(0)) && (allSmall == word.length() - 1))) return true;

        return false;
    }

    public boolean isCapital(char ch) {
        return (ch >= 65 && ch <= 90);
    }
}
