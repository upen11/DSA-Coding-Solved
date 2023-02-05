class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            boolean flag = false;
            int jump = 0;
            int cut = 0;
            int index = row;
            while (index < n) {
                sb.append(s.charAt(index));
                jump = 2 * (numRows - 1);
                
                if (row != 0 && row != numRows - 1) {
                    if (flag == false) {
                        cut = 2 * row;
                        jump -= cut;
                        flag = true;
                    } else {
                        jump = cut;
                        flag = false;
                    }
                }
                index += jump;
            }
        }

        return sb.toString();
    }
    /*
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder res = new StringBuilder();

        // will make numRows StringBuilders then at last club them
        // row wise storing in string builders array
        StringBuilder[] sbs = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        // index will point to string
        int index = 0;
        int n = s.length();

        // Traverse ZigZag
        while (index < n) {
            // go down
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(s.charAt(index++));
            }

            // go up from row-2 i.e second last row
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                sbs[j].append(s.charAt(index++));
            }
        }
        
        System.out.print(sbs[1].toString());

        // at last clubbing whole string builder array into 1 string builder
        for (int i = 0; i < numRows; i++) {
            res.append(sbs[i]);
        }

        return res.toString();
    }
    
    */
}
