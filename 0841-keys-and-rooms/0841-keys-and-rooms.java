class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;

        if (rooms.size() == 1) return true;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        // bfs
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer neighbour : rooms.get(node)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
