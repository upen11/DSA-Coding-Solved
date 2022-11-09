class Solution {
    public List<String> letterCombinations(String s) {
        
        // Write your code here
        ArrayList<String> combi = new ArrayList<>();
        
        if(s.length() == 0) {   // s=="" will not work
            return combi;
        }
        HashMap<Character, String> map = new HashMap<>();
        
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        combinations(0, s, map, new StringBuilder(), combi);
        
        return combi;
}
    
    public static void combinations(int ind, String s, HashMap<Character, String> map, StringBuilder sb, ArrayList<String> combi) {
     
        if(ind == s.length()) {
            combi.add(sb.toString());
            return;
        }
        
        //abc ..//def
        String str = map.get(s.charAt(ind));
        for(int i=0; i<str.length(); i++) {

            //str
            sb.append(str.charAt(i));
            combinations(ind+1, s, map, sb, combi);
            sb.deleteCharAt(sb.length()-1);
           
        }    
    }
}