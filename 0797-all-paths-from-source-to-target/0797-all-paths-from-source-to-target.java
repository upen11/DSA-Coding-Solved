class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, 0, ans, temp);

        return ans;
    }

    public void dfs(int[][] graph, int ind, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (ind == graph.length - 1) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int num : graph[ind]) {
            temp.add(num);
            dfs(graph, num, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
