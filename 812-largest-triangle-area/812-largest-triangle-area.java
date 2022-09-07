class Solution {

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        double area = 0.0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    area = Math.abs((points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1])) / 2.0);

                    System.out.println("i=" + i + " j=" + j + " k=" + k);
                    System.out.println("area :" + area);

                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
