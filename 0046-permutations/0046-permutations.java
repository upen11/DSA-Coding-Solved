class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking(nums, result, new ArrayList<>());

        return result;
    }

    public void backtracking(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;

            temp.add(nums[i]);

            // System.out.println(temp);
            backtracking(nums, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
