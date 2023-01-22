class Solution {

    boolean isPalindrome(String s, int st, int end) {
        while (st < end) {
            if (s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }

    void backtrack(String s, int idx, List<List<String>> result, List<String> curr) {
        if (idx == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        backtrack(s, 0, result, ans);

        return result;
    }
}
