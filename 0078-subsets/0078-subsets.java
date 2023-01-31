class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(temp);
        backtracking(nums, nums.length, 0, result, temp);

        return result;
    }

    public void backtracking(int[] nums, int n, int idx, List<List<Integer>> result, List<Integer> temp) {
        
        for (int i = idx; i < n; i++) {
            temp.add(nums[i]);
            // System.out.println(temp);
            result.add(new ArrayList<>(temp)); 
            backtracking(nums, n, i + 1, result, temp);
            
            temp.remove(temp.size() - 1);
        }
    }
}
