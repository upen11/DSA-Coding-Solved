class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Freq = new HashMap<>();
        Map<Character, Integer> s2Freq = new HashMap<>();

        int p1 = 0;
        int p2 = s1.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            s1Freq.put(s1.charAt(i), s1Freq.getOrDefault(s1.charAt(i), 0) + 1);
            s2Freq.put(s2.charAt(i), s2Freq.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (s2Freq.get(s2.charAt(p2)) == 1) 
            s2Freq.remove(s2.charAt(p2)); 
        else 
            s2Freq.put(s2.charAt(p2), s2Freq.getOrDefault(s2.charAt(p2), 0) - 1);

        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            s2Freq.put(s2.charAt(p2), s2Freq.getOrDefault(s2.charAt(p2), 0) + 1);

            if (matches(s1Freq, s2Freq)) return true;

            if (s2Freq.get(s2.charAt(p1)) == 1) 
                s2Freq.remove(s2.charAt(p1)); 
            else 
                s2Freq.put(s2.charAt(p1), s2Freq.getOrDefault(s2.charAt(p1), 0) - 1);

            p1++;
            p2++;
        }

        return false;
    }

    public boolean matches(Map<Character, Integer> s1Freq, Map<Character, Integer> s2Freq) {
        for (char key : s1Freq.keySet()) {
            if (s1Freq.get(key) - s2Freq.getOrDefault(key, -1) != 0) return false;
        }

        return true;
    }
}
