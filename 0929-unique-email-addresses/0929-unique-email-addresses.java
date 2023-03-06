class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        StringBuilder sb;
        for (String s : emails) {
            sb = new StringBuilder();

            boolean flag = false;
            int i = -1;
            while (s.charAt(++i) != '@') {
                if (s.charAt(i) == '+') {
                    flag = true;
                }

                if (s.charAt(i) == '.') {
                    continue;
                } else if (flag == true) {
                    continue;
                } else {
                    sb.append(s.charAt(i));
                }
            }

            while (i < s.length()) {
                sb.append(s.charAt(i++));
            }

            set.add(sb.toString());
        }

        // System.out.println(set);

        return set.size();
    }
}
