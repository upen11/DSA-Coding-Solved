class Solution {
    public String longestCommonPrefix(String[] strs) {
     
        Arrays.sort(strs);
        
        String s = strs[0];
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=0; i<s.length(); i++) {
            for(int j=1; j<strs.length; j++) {
                // System.out.println("i :" + i + " ,j : "+ j);
                // System.out.println("strs[j].charAt(i) : " + strs[j].charAt(i));
                // System.out.println("s.charAt(i) : "+ s.charAt(i));
                if(strs[j].charAt(i) != s.charAt(i)) {
                    flag = true;
                    break;
                } 
            }
            if(flag == false) {
                sb.append(s.charAt(i));
            }
            else {
                break;
            }
                
        }
        
        return sb.toString();
    }
}