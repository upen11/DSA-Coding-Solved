class Solution {
    public int[] plusOne(int[] digits) {
     
        int[] res = null;
        
        int count = 0;
        for(int i=0; i<digits.length; i++) {
            if(digits[i] == 9) {
                count++;
            }
        }
        
        if(count == digits.length) {
            res = new int[digits.length+1];
        }
        else {
            res = new int[digits.length];
        }
        
        
        int sum = 0;
        int carry = 1;
        int j = res.length-1;;
        for(int i=digits.length-1; i>=0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            res[j--] = sum;
        }
        
        if(carry > 0) {
            res[j] = carry;
        }
        
        return res;
    }
}