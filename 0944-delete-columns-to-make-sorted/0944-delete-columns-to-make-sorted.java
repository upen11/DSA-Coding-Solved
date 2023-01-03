class Solution {
    public int minDeletionSize(String[] strs) {
        
        int count = 0;
        for(int i=0; i<strs[0].length(); i++) {
            for(int j=0; j<strs.length-1; j++) {
                char ch1 = strs[j].charAt(i);
                char ch2 = strs[j+1].charAt(i);
                
                if(ch2 - ch1 < 0) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}