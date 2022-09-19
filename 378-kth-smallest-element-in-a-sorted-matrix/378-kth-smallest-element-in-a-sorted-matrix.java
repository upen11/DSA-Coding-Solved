class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        if(k == 1 && matrix.length == 1)
            return matrix[0][k-1];
        
       int[] arr = new int[matrix.length*matrix[0].length];
        
       // storing elements in 1-d array
        int i, j, x = 0;
        for (i = 0; i < matrix.length; i++)
        {
            for (j = 0; j < matrix[0].length; j++)
            {
                x = i * matrix.length + j;
                arr[x] = matrix[i][j];
                x++;
            }
        }
        
        Arrays.sort(arr);
        
        for(int r : arr)
            System.out.print(r+" ");
        
        return arr[k-1];
    }
}