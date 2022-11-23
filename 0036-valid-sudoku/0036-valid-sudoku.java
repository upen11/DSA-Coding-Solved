public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';

                    if (row[n][i]) return false;
                    row[n][i] = true;

                    if (col[n][j]) return false;
                    col[n][j] = true;

                    int bi = (i / 3) * 3 + (j / 3);

                    if (box[n][bi]) return false;
                    box[n][bi] = true;
                }
            }
        }

        return true;
    }
}
