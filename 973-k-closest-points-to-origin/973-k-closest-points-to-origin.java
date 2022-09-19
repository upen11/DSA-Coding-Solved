class Solution {

    public int[][] kClosest(int[][] points, int k) {
        // List<List<Integer>> list = new ArrayList<>();
        int[][] disArr = new int[points.length][2];
        int[][] arr = new int[k][2];

        int dis = 0;
        for (int i = 0; i < points.length; i++) {
            dis = (int) ((Math.pow(points[i][1], 2)) + (Math.pow(points[i][0], 2)));
            disArr[i][0] = dis;
            disArr[i][1] = i;
        } // System.out.println(dis);
        Arrays.sort(
            disArr,
            new Comparator<int[]>() {

                @Override
                public int compare(int[] entry1, int[] entry2) {
                    Integer time1 = entry1[0];
                    Integer time2 = entry2[0];
                    return time1.compareTo(time2);
                }
            }
        );

        // for (int i = 0; i < disArr.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         System.out.print(disArr[i][j] + " ");
        //     }
        // System.out.println();
        // }
        for (int x = 0; x < k; x++) {
            arr[x][0] = points[disArr[x][1]][0];
            arr[x][1] = points[disArr[x][1]][1];
        }
        // System.out.println("---------------");

        return arr;
    }
}
