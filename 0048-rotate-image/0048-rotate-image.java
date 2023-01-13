class Solution {

    public void rotate(int[][] matrix) {
        // for rotating clockwise
        // 1. Transpose i,j
        // 2. Swap columns left to right

        // transpose;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row != col) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                } else {
                    break;
                }
            }
        }

        // swapping columns till n/2
        int n = matrix[0].length - 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length / 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n - col];
                matrix[row][n - col] = temp;
            }
        }
    }
}
