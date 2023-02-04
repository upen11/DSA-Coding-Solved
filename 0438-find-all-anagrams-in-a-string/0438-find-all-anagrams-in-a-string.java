class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();

        // p should be smaller than s
        if(p.length() > s.length()) return res;
        
        int p1 = 0;
        int p2 = p.length() - 1;

        int[] sFreq = new int[26];
        int[] pFreq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }

        sFreq[s.charAt(p2) - 'a']--;

        boolean flag = false;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            sFreq[s.charAt(p2) - 'a']++;
            flag = isAnagram(sFreq, pFreq);

            if (flag) {
                res.add(i);
            }

            sFreq[s.charAt(p1)-'a']--;

            p1++;
            p2++;
        }

        return res;
    }

    public boolean isAnagram(int[] sFreq, int[] pFreq) {
        for (int i = 0; i < 26; i++) {
            if (sFreq[i] != pFreq[i]) return false;
        }
        return true;
    }
}
