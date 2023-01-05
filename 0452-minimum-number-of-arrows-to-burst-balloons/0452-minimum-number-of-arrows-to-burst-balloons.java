class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (int[] p1, int[] p2)->{
		    // Don't use p1[1 ] - p2[1]. It may overflow 
            return p1[0] < p2[0] ? -1 : 1;
        });
        int start = points[0][0], end = points[0][1];
		
		// the reason res = 1 is that we need an arrow to destroy the last group. 
        int res = 1;
        for (int[] point: points)
        {
            if (point[0]<= end)
            {
                start= Math.max(start, point[0]);
                end = Math.min(end, point[1]);
            }
            else
            {
                res++;
                start = point[0];
                end = point[1];
            }
        }
        return res;
    }
}