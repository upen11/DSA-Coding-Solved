class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        StringBuilder sb = new StringBuilder();
        
        if(s.length() != t.length())
            return false;

        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        
        // "badc"
        // "baba"
        // false
        for(int i=0; i<s.length(); i++) {
            
            if(mapS.containsKey(s.charAt(i))) {
                if(mapS.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else {
                mapS.put(s.charAt(i), t.charAt(i));
            }
        }
        
        for(int i=0; i<t.length(); i++) {
            
            if(mapT.containsKey(t.charAt(i))) {
                if(mapT.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
            else {
                mapT.put(t.charAt(i), s.charAt(i));
            }
        }
        
        System.out.println(mapS);
        System.out.println(mapT);
        
        return true;
    }
}