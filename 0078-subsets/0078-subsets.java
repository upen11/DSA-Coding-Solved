class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking(nums, nums.length, 0, result, new ArrayList<>());

        return result;
    }

    public void backtracking(int[] nums, int n, int idx, List<List<Integer>> result, List<Integer> temp) {
        if (idx == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        backtracking(nums, n, idx + 1, result, temp);
        temp.remove(temp.size() - 1);
        backtracking(nums, n, idx + 1, result, temp);
    }
}
