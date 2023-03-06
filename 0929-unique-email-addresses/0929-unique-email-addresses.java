class Solution {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        StringBuilder sb;
        for (String s : emails) {
            sb = new StringBuilder();

            boolean flag = false;
            int i = 0;
            while (s.charAt(i) != '@') {
                if (s.charAt(i) == '+') {
                    flag = true;
                }
                if (flag == true || (s.charAt(i) == '.')) {
                    // continue; will not use i++ on line 22 and return with same i;
                } else {
                    sb.append(s.charAt(i));
                }
                
                i++;
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
