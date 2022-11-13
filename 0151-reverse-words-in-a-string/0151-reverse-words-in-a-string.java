class Solution {
    public String reverseWords(String s) {
        
        Stack<String> stack = new Stack<>();
        
        StringBuilder word = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == ' ') {
                continue;
            }
            
            while(i<s.length() && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i++;
            }
            
            stack.push(new String(word));
            // System.out.println(stack);
            word.setLength(0);
        }
        
        // System.out.println(stack);
        
        while(!stack.isEmpty()) {
            word.append(stack.pop());
            word.append(' ');
        }
        
        word.deleteCharAt(word.length() - 1);
        
        return word.toString();
    }
}