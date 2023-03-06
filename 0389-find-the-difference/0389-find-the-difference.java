class Solution {
    public char findTheDifference(String s, String t) {
        
        long sum = 0;
        
        for(int i=0; i<t.length(); i++) {
            sum += t.charAt(i) - 'a';
        }
        
        for(int i=0; i<s.length(); i++) {
            sum -= s.charAt(i) - 'a';
        }
        
        // System.out
        
        return (char) (sum + 97);
    }
}