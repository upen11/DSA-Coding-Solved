class Solution {

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = null;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list = map.get(arr[i]);
            } else {
                list = new ArrayList<>();
            }

            list.add(i);
            map.put(arr[i], list);
        }

        // System.out.println(map);

        boolean[] isVisited = new boolean[arr.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisited[0] = true;

        int jump = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();
                
                if(curr == arr.length-1) return jump;

                // below will not work
                // if (arr[curr] == arr[arr.length - 1]) {
                //     return jump;
                // }

                int left = curr - 1;
                int right = curr + 1;

                if (left >= 0 && !isVisited[left]) {
                    queue.offer(left);
                    isVisited[left] = true;
                }

                if ((right < arr.length) && (isVisited[right] == false)) {
                    queue.offer(right);
                    isVisited[right] = true;
                }

                if (map.containsKey(arr[curr])) {
                    list = map.get(arr[curr]);

                    for (int a : list) {
                        if (isVisited[a] == false) {
                            queue.offer(a);
                            isVisited[a] = true;
                        }
                    }

                    map.remove(arr[curr]);
                }
                
            }
            
            jump++;
        }

        return 0;
    }
}
