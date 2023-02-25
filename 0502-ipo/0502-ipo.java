class Solution {

    class PC implements Comparable<PC> {
        int capital;
        int profit;

        public PC(int c, int p) {
            this.capital = c;
            this.profit = p;
        }

        public int compareTo(PC obj) {
            if (this.capital == obj.capital) {
                return obj.profit - this.profit;
            }
            return this.capital - obj.capital;
        }

        public String toString() {
            return "capital : " + capital + ",  profit : " + profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PC[] arr = new PC[capital.length];

        for (int i = 0; i < capital.length; i++) {
            arr[i] = new PC(capital[i], profits[i]);
        }

        // Arrays.sort(arr, (obj1, obj2) -> {
        //         if(obj1.capital == obj2.capital) {
        //             return obj2.profit - obj1.profit;
        //         }
        //     else {
        //         return obj1.capital - obj2.capital;
        //     }
        // });

        Arrays.sort(arr);

        // System.out.println(Arrays.toString(arr));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int idx = 0;
        for (int i = 0; i < k; i++) {
            while ((idx < capital.length) && (w >= arr[idx].capital)) {
                pq.add(arr[idx++].profit);
                // we will not come this capital again
            }
            // while ended

            if (!pq.isEmpty()) {
                w += pq.remove();
            } else {
                break;
            }
        }

        return w;
    }
}
