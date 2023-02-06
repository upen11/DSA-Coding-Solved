class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new LinkedList<>();

        list.add(new int[] { intervals[0][0], intervals[0][1] });

        for (int i = 1; i < intervals.length; i++) {
            int[] arr = list.get(list.size() - 1);

            if (intervals[i][0] <= arr[1] && arr[1] <= intervals[i][1]) {
                // [1, 3] [2, 6]
                arr[1] = intervals[i][1];
                list.remove(list.size() - 1);
                list.add(new int[] { arr[0], arr[1] });
            } else if (arr[0] <= intervals[i][0] && arr[1] >= intervals[i][1]) {
                // [1, 6] [2, 4]
                continue;
            } else {
                // [8, 10]
                list.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] arr : list) {
            res[i][0] = arr[0];
            res[i][1] = arr[1];
            i++;
        }

        return res;
    }
}
