class Solution {

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < path.length(); i++) {
            // char ch = path.charAt(i);

            while (i < path.length() && path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                i++;
            }

            // System.out.println(sb);
            if (sb.length() != 0) {
                // System.out.println(sb);
                // System.out.println(sb.toString().equals(".."));
                if (sb.toString().equals("..") && !stack.isEmpty()) {
                    stack.pop();
                } else if (sb.toString().equals("..") && stack.isEmpty()) {
                    // continue is wrong, here do nothing;
                } else if (!sb.toString().equals(".")) {
                    stack.push(sb.toString());
                }
            }

            sb.setLength(0);    // emptying sb
        }

        // System.out.println(stack);

        StringBuilder dir = new StringBuilder("/");
        
        if (!stack.isEmpty()) 
            dir.append(stack.pop());
        
        while (!stack.isEmpty()) {
            // System.out.println(dir);
            // dir = "/" + stack.pop() + dir;
            dir.insert(0,("/"+stack.pop()));
            // System.out.println(st);
        }

        return dir.toString();
    }
}
