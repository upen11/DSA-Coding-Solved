class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = findingRow(matrix, target);
        
        if(row == -1) return false;
        
        int start = 0;
        int end = matrix[row].length-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid]> target) end = mid - 1;
            else start = mid + 1;
        }
        
        return false;
    }
    
    public int findingRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        int rowLen = matrix[0].length-1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(target >= matrix[mid][0] && target <= matrix[mid][rowLen] ) {
                return mid;
            }
            else if (target > matrix[mid][0] && target > matrix[mid][rowLen] ) {
                start = mid + 1;
            }
            else if (target < matrix[mid][0] && target < matrix[mid][rowLen] ) {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}