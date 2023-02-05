class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();

        if (p.length() > s.length()) return res;

        Map<Character, Integer> pFreq = new HashMap<>();
        Map<Character, Integer> sFreq = new HashMap<>();

        int p1 = 0;
        int p2 = p.length() - 1;

        for (int i = 0; i < p.length(); i++) {
            pFreq.put(p.charAt(i), pFreq.getOrDefault(p.charAt(i), 0) + 1);
            sFreq.put(s.charAt(i), sFreq.getOrDefault(s.charAt(i), 0) + 1);
        }

        if (sFreq.get(s.charAt(p2)) == 1) 
            sFreq.remove(s.charAt(p2)); 
        else 
            sFreq.put(s.charAt(p2), sFreq.getOrDefault(s.charAt(p2), 0) - 1);

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            sFreq.put(s.charAt(p2), sFreq.getOrDefault(s.charAt(p2), 0) + 1);

            if (matches(pFreq, sFreq)) res.add(i);

            if (sFreq.get(s.charAt(p1)) == 1) 
                sFreq.remove(s.charAt(p1)); 
            else 
                sFreq.put(s.charAt(p1), sFreq.getOrDefault(s.charAt(p1), 0) - 1);

            p1++;
            p2++;
        }

        return res;
    }

    public boolean matches(Map<Character, Integer> s1Freq, Map<Character, Integer> s2Freq) {
        for (char key : s1Freq.keySet()) {
            if (s1Freq.get(key) - s2Freq.getOrDefault(key, -1) != 0)
                return false;
        }

        return true;
    }
}
