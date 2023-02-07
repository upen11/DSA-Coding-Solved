class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) return true;

        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(count)) {
            return false;
        }

        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, -1, 0, 1 };

        char temp = board[i][j];
        boolean res = false;
        board[i][j] = '*';
        for (int ind = 0; ind < 4; ind++) {
            res = dfs(board, i + di[ind], j + dj[ind], count + 1, word);
            if (res) {
                break;
            }
        }

        board[i][j] = temp;
        return res;
    }
}
