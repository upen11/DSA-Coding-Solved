class Solution {
    public int strStr(String haystack, String needle) {
     
        
        int bigLen = haystack.length();
        int smallLen = needle.length();
        
        if(bigLen < smallLen) return -1;
        
        for(int i=0; i<=bigLen - smallLen; i++) {
            String regex = haystack.substring(i, i+smallLen);
            
            if(regex.equals(needle)) {
                return i;
            }
        }
        
        return -1;
    }
}