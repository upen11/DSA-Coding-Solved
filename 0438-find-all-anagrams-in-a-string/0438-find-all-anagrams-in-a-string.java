class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            flag = isAnagram(p, s.substring(i, i + p.length()));

            if (flag == true) res.add(i);
        }

        return res;
    }

    public boolean isAnagram(String p, String str) {
        int[] pArr = new int[26];
        int[] strArr = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            strArr[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            if (strArr[p.charAt(i) - 'a'] == 0) {
                return false;
            } else {
                strArr[p.charAt(i) - 'a']--;
            }
        }

        return true;
    }
}
