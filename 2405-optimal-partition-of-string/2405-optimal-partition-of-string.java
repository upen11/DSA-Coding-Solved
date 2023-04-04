class Solution {

    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                count++;
                set.clear();
                set.add(ch);
            }
        }

        if (!set.isEmpty()) count++;

        return count;
    }
}
