class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        int[] ans = new int[word.length()];
            
        long num = 0;        
        for(int i=0; i<word.length(); i++) {
            
            char c = word.charAt(i);
            
            num = (10 * num + (c - '0')) % m;
            // System.out.print(num + " ");
            
            if(num == 0) {
                ans[i] = 1;
            }
            else {
                ans[i] = 0;
            }
        }
        
        return ans;
    }
}