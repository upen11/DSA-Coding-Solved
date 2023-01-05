class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        // starting from the top right of the matrix
        // we observe that values in col are increasing and row is decreasing
        int row = 0;
        int col = matrix[0].length - 1;

        // while we are inside matrix
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) 
                return true; 
            else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
