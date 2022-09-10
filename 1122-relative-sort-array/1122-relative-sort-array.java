class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        Arrays.sort(arr1);
        
        int[] relSort = new int[arr1.length];
        
        int k = 0;
         
        for(int i=0; i<arr2.length; i++) {
            
            for(int j=0; j<arr1.length; j++) {
                
                if(arr2[i] == arr1[j]) {
                    relSort[k++] = arr1[j];
                    arr1[j] = -1;
                }
            }
        }
        
        for(int i=0; i<relSort.length; i++) {
            if(arr1[i] != -1) {
                relSort[k++] = arr1[i];
            }
        }
        
        return relSort;
    }
}