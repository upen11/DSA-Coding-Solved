class Solution {
    public String countAndSay(int n) {
        
        if(n==1) {
            return "1";
        }
        
        if(n==2) {
            return "11";
        }
        
        String s = "11";
        String ans = s;
        
        int x = 2;
        while(++x <= n) {
            s = count(s);
            ans = s;
        }
        
        return ans;
        
    }

    public String count(String num) {

        
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        
        int i = 0;
        for(i=0; i<num.length()-1; i++) {
            char ch = num.charAt(i);
            char ch1 = num.charAt(i+1);
            
            if(ch == ch1) {
                count++;
            }
            else {
                sb.append(count);
                sb.append(ch);
                count = 1;
            }   
        }

        sb.append(count);
        sb.append(num.charAt(i));       // last character
  
        
        return sb.toString();
        
    }
}