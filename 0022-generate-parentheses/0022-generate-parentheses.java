class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtracking(n, 0, result, new StringBuilder(), 0, 0);

        return result;
    }

    public void backtracking(int n, int idx, List<String> result, StringBuilder temp, int openBracket, int closedBracket) {
        if (idx == n * 2) {
            result.add(temp.toString());
            return;
        }

        if (openBracket < n) {
            backtracking(n, idx + 1, result, temp.append("("), openBracket + 1, closedBracket); // ++ will not work
            temp.deleteCharAt(temp.length() - 1);
        }

        if (closedBracket < openBracket) {
            backtracking(n, idx + 1, result, temp.append(")"), openBracket, closedBracket + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
