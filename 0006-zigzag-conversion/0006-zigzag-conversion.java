class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        
         StringBuilder res = new StringBuilder();
        
        // will make numRows StringBuilders then at last club them
        // row wise storing in string builders array
        StringBuilder[] sbs = new StringBuilder[numRows];
        
        for(int i=0; i<numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        
        // index will point to string
        int index = 0;
        int n = s.length();
        
        // Traverse ZigZag
        while(index < n) {
            // go down
            for(int j=0; j<numRows && index < n; j++) {
                sbs[j].append(s.charAt(index++));
            }
            
            // go up from row-2 i.e second last row
            for(int j=numRows-2; j>0 && index < n; j--) {
                sbs[j].append(s.charAt(index++));
            }
        }
        
       
       // at last clubbing whole string builder array into 1 string builder 
        for(int i=0; i<numRows; i++) {
            res.append(sbs[i]);
        }
        
        return res.toString();
    }
}