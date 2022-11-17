class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 24 + 27 - 6 = 45
        
        int rectArea1 = (ay2 - ay1) * (ax2 - ax1);;
        
        int rectArea2 = (by2 - by1) * (bx2 - bx1);
        
        int areaOfOverlap = 0;
        
        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }
        
        return rectArea1 + rectArea2 - areaOfOverlap;
        
    }
}