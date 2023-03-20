class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        
        if(n==0) return true;
        
        for(int i=0; i<len; i++) {
            boolean isLeftEmpty = false;
            boolean isRightEmpty = false;
            
            if(flowerbed[i] == 0) {
                isLeftEmpty = i==0 || flowerbed[i-1] == 0;
                isRightEmpty = i==len-1 || flowerbed[i+1] == 0;
            }
            
            if(isLeftEmpty == true && isRightEmpty == true) {
                flowerbed[i] = 1;
                n--;
            }
            
            if(n==0) return true;
        }
        
        return false;
    }
}